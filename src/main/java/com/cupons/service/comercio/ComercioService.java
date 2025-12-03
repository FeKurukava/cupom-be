package com.cupons.service.comercio;

import com.cupons.models.categoria.Categoria;
import com.cupons.models.comercio.Comercio;
import com.cupons.models.comercio.ComercioRequestBody;
import com.cupons.models.cupom.Cupom;
import com.cupons.models.cupom.CupomAssociado;
import com.cupons.models.cupom.CupomRequestBody;
import com.cupons.repository.categoria.CategoriaRepository;
import com.cupons.repository.comercio.ComercioRepository;
import com.cupons.repository.cupom.CupomRepository;
import com.cupons.repository.cupom.CupomAssociadoRepository;
import com.cupons.utils.DocumentoUtils;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class ComercioService {

    private final ComercioRepository comercioRepository;
    private final CupomRepository cupomRepository;
    private final CupomAssociadoRepository cupomAssociadoRepository;
    private final CategoriaRepository categoriaRepository;

    public ComercioService(ComercioRepository comercioRepository, CupomRepository cupomRepository, CategoriaRepository categoriaRepository, CupomAssociadoRepository cupomAssociadoRepository) {
        this.comercioRepository = comercioRepository;
        this.cupomRepository = cupomRepository;
        this.categoriaRepository = categoriaRepository;
        this.cupomAssociadoRepository = cupomAssociadoRepository;
    }

    public void novoComercio(@Valid ComercioRequestBody requestBody) {

        String cnpjLimpo = DocumentoUtils.limparDocumento(requestBody.getCnpjComercio());

        if (comercioRepository.findById(cnpjLimpo).isPresent()) {
            throw new RuntimeException("Comércio já cadastrado com este CNPJ.");
        }

        Categoria categoria = categoriaRepository.findById(requestBody.getIdCategoria()).orElseThrow(() -> new RuntimeException("Categoria não encontrada."));

        Comercio comercio = new Comercio();

        comercio.setCnpjComercio(cnpjLimpo);
        comercio.setCategoria(categoria);
        comercio.setRazSocialComercio(requestBody.getRazSocialComercio());
        comercio.setNomFantasiaComercio(requestBody.getNomFantasiaComercio());
        comercio.setEndComercio(requestBody.getEndComercio());
        comercio.setBaiComercio(requestBody.getBaiComercio());
        comercio.setCepComercio(requestBody.getCepComercio());
        comercio.setCidComercio(requestBody.getCidComercio());
        comercio.setUfComercio(requestBody.getUfComercio());
        comercio.setConComercio(requestBody.getConComercio());
        comercio.setEmailComercio(requestBody.getEmailComercio());
        comercio.setSenComercio(requestBody.getSenComercio());

        comercioRepository.save(comercio);
    }

    public void gerarCupom(@Valid CupomRequestBody cupomRequestBody) {
        String cnpj = DocumentoUtils.limparDocumento(cupomRequestBody.getCnpjComercio());

        Comercio comercio = comercioRepository.findById(cnpj)
                    .orElseThrow(() -> new RuntimeException("Comércio não encontrado."));

        validarDatas(cupomRequestBody.getDataValidadeInicio(), cupomRequestBody.getDataValidadeFim());

        Cupom cupom = converterParaEntidade(cupomRequestBody, comercio);
        cupom.setNumCupom(gerarCodigoCupom());

        cupomRepository.save(cupom);
        }

    private Cupom converterParaEntidade(CupomRequestBody dto, Comercio comercio) {
        Cupom cupom = new Cupom();
        cupom.setTituloCupom(dto.getTituloPromo());
        cupom.setDtaInicioCupom(dto.getDataValidadeInicio());
        cupom.setDtaTerminoCupom(dto.getDataValidadeFim());
        cupom.setDtaEmissaoCupom(new Date());
        cupom.setPerDescCupom(dto.getDescontoPromo());
        cupom.setQntCupom(dto.getQntCupom());
        cupom.setComercio(comercio);
        return cupom;
    }

    private void validarDatas(Date inicio, Date fim) {

        Date hoje = new Date();

        if (inicio.before(hoje)) {
            throw new RuntimeException("A data de início não pode ser no passado.");
        }

        if (fim.before(inicio)) {
            throw new RuntimeException("A data de fim deve ser posterior à data de início.");
        }
    }

    private String gerarCodigoCupom() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder codigo = new StringBuilder();

        for (int i = 0; i < 12; i++) {
            int index = (int) (Math.random() * caracteres.length());
            codigo.append(caracteres.charAt(index));
        }

        return codigo.toString();
    }

    public void registrarUsoCupom(String numCupom) {
        Cupom cupom = cupomRepository.findById(numCupom)
                .orElseThrow(() -> new RuntimeException("Cupom não encontrado."));

        Date hoje = new Date();

        if (cupom.getDtaInicioCupom() == null || cupom.getDtaTerminoCupom() == null) {
            throw new RuntimeException("Período do cupom inválido.");
        }

        if (hoje.before(cupom.getDtaInicioCupom())) {
            throw new RuntimeException("Cupom ainda não está ativo.");
        }

        if (hoje.after(cupom.getDtaTerminoCupom())) {
            throw new RuntimeException("Cupom vencido.");
        }

        CupomAssociado cupomAssociado = cupomAssociadoRepository.findFirstByCupom_NumCupomAndDtaUsoCupomAssociadoIsNull(numCupom);

        if (cupomAssociado == null) {
            throw new RuntimeException("Cupom não reservado ou já utilizado.");
        }

        cupomAssociado.setDtaUsoCupomAssociado(new Date());
        cupomAssociadoRepository.save(cupomAssociado);
    }

}

