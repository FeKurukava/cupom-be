package com.cupons.service.associado;

import com.cupons.models.associado.Associado;
import com.cupons.models.associado.AssociadoRequestBody;
import com.cupons.models.auth.RecuperarSenhaAssociadoRequest;
import com.cupons.models.comercio.Comercio;
import com.cupons.models.comercio.ComercioResponse;
import com.cupons.models.cupom.Cupom;
import com.cupons.models.cupom.CupomAssociado;
import com.cupons.models.cupom.CupomResponse;
import com.cupons.models.cupom.ReservarCupomRequest;
import com.cupons.repository.associado.AssociadoRepository;
import com.cupons.repository.comercio.ComercioRepository;
import com.cupons.repository.cupom.CupomAssociadoRepository;
import com.cupons.repository.cupom.CupomRepository;
import com.cupons.service.cupom.CupomService;
import com.cupons.utils.DocumentoUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AssociadoService {

    private final AssociadoRepository associadoRepository;
    private final ComercioRepository comercioRepository;
    private final CupomRepository cupomRepository;
    private final CupomAssociadoRepository cupomAssociadoRepository;
    private final CupomService cupomService;

    public AssociadoService(AssociadoRepository associadoRepository, ComercioRepository comercioRepository, CupomRepository cupomRepository, CupomAssociadoRepository cupomAssociadoRepository, CupomService cupomService) {
        this.associadoRepository = associadoRepository;
        this.comercioRepository = comercioRepository;
        this.cupomRepository = cupomRepository;
        this.cupomAssociadoRepository = cupomAssociadoRepository;
        this.cupomService = cupomService;
    }

    public Associado novoUsuario(AssociadoRequestBody requestBody){

        Associado associado = new Associado();

        associado.setCpfAssociado(DocumentoUtils.limparDocumento(requestBody.getCpfAssociado()));
        associado.setNomAssociado(requestBody.getNomAssociado());
        associado.setDtnAssociado(requestBody.getDtnAssociado());
        associado.setEndAssociado(requestBody.getEndAssociado());
        associado.setBaiAssociado(requestBody.getBaiAssociado());
        associado.setCepAssociado(requestBody.getCepAssociado());
        associado.setCidAssociado(requestBody.getCidAssociado());
        associado.setUfAssociado(requestBody.getUfAssociado());
        associado.setCelAssociado(requestBody.getCelAssociado());
        associado.setEmailAssociado(requestBody.getEmailAssociado());
        associado.setSenAssociado(requestBody.getSenAssociado());

        return associadoRepository.save(associado);
    }

    public List<ComercioResponse> listarComercios(){
        List<Comercio> lista = comercioRepository.findAll();
        List<ComercioResponse> respostas = new ArrayList<>();
        for (Comercio c : lista){
            ComercioResponse r = new ComercioResponse();
            r.setCnpjComercio(c.getCnpjComercio());
            r.setRazSocialComercio(c.getRazSocialComercio());
            r.setNomFantasiaComercio(c.getNomFantasiaComercio());
            r.setCidComercio(c.getCidComercio());
            r.setUfComercio(c.getUfComercio());
            respostas.add(r);
        }
        return respostas;
    }

    public List<CupomResponse> listarCuponsPorCnpj(String cnpj, String status){
        return cupomService.listarCuponsPorCnpj(cnpj, status);
    }

    public void reservarCupom(ReservarCupomRequest request){
        String cpf = DocumentoUtils.limparDocumento(request.getCpfAssociado());
        Associado associado = associadoRepository.findById(cpf).orElseThrow(() -> new RuntimeException("Associado não encontrado."));

        Cupom cupom = cupomRepository.findById(request.getNumCupom()).orElseThrow(() -> new RuntimeException("Cupom não encontrado."));

        Date hoje = new Date();
        if (cupom.getDtaInicioCupom() == null || cupom.getDtaTerminoCupom() == null){
            throw new RuntimeException("Período do cupom inválido.");
        }
        if (hoje.before(cupom.getDtaInicioCupom())){
            throw new RuntimeException("Cupom ainda não está ativo.");
        }
        if (hoje.after(cupom.getDtaTerminoCupom())){
            throw new RuntimeException("Cupom vencido.");
        }

        CupomAssociado jaReservado = cupomAssociadoRepository.findFirstByCupom_NumCupomAndDtaUsoCupomAssociadoIsNull(cupom.getNumCupom());
        if (jaReservado != null){
            throw new RuntimeException("Cupom já reservado por outro associado.");
        }

        Integer maxId = cupomAssociadoRepository.buscarMaiorId();
        int novoId = maxId == null ? 1 : maxId + 1;

        CupomAssociado cupomAssociado = new CupomAssociado();
        cupomAssociado.setIdCupomAssociado(novoId);
        cupomAssociado.setAssociado(associado);
        cupomAssociado.setCupom(cupom);
        cupomAssociado.setDtaCupomAssociado(new Date());

        cupomAssociadoRepository.save(cupomAssociado);
    }

    public List<CupomResponse> buscarCuponsAssociado(String cpf, String status){
        String cpfLimpo = DocumentoUtils.limparDocumento(cpf);
        associadoRepository.findById(cpfLimpo).orElseThrow(() -> new RuntimeException("Associado não encontrado."));

        List<CupomAssociado> lista;
        if (status != null && status.equalsIgnoreCase("VENCIDOS")) {
            lista = cupomAssociadoRepository.buscarVencidosPorCpf(cpfLimpo);

        }else if (status != null && status.equalsIgnoreCase("UTILIZADOS")) {
            lista = cupomAssociadoRepository.buscarUtilizadosPorCpf(cpfLimpo);

        } else {
            lista = cupomAssociadoRepository.buscarReservadosPorCpf(cpfLimpo);
        }

        List<CupomResponse> respostas = new ArrayList<>();
        for (CupomAssociado ca : lista){
            Cupom c = ca.getCupom();
            CupomResponse cupomResponse = new CupomResponse();
            cupomResponse.setNumCupom(c.getNumCupom());
            cupomResponse.setTituloCupom(c.getTituloCupom());
            cupomResponse.setDtaEmissaoCupom(c.getDtaEmissaoCupom());
            cupomResponse.setDtaInicioCupom(c.getDtaInicioCupom());
            cupomResponse.setDtaTerminoCupom(c.getDtaTerminoCupom());
            if (c.getPerDescCupom() != null){
                BigDecimal valor = new BigDecimal(c.getPerDescCupom().toString());
                cupomResponse.setPerDescCupom(valor);
            } else {
                cupomResponse.setPerDescCupom(null);
            }
            cupomResponse.setQntCupom(c.getQntCupom());
            respostas.add(cupomResponse);
        }
        return respostas;
    }
}
