package com.cupons.service.cupom;

import com.cupons.models.cupom.Cupom;
import com.cupons.models.cupom.CupomResponse;
import com.cupons.models.cupom.StatusCupom;
import com.cupons.repository.cupom.CupomRepository;
import com.cupons.utils.DocumentoUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CupomService {

    private final CupomRepository cupomRepository;

    public CupomService(CupomRepository cupomRepository) {
        this.cupomRepository = cupomRepository;
    }

    public List<CupomResponse> listarCuponsPorCnpj(String cnpj, String status) {

        String cnpjLimpo = DocumentoUtils.limparDocumento(cnpj);

        StatusCupom filtro;
        try {
            filtro = StatusCupom.valueOf(status.toUpperCase());
        } catch (Exception e) {
            throw new RuntimeException("Status inválido. Use: ATIVOS ou VENCIDOS.");
        }
        List<Cupom> resultado = null;


        switch (filtro) {
            case ATIVOS ->{
               resultado =  cupomRepository.findAtivosByCnpj(cnpjLimpo);
            }
            case VENCIDOS ->{
                resultado = cupomRepository.findVencidosByCnpj(cnpjLimpo);
            }
        };
        List<CupomResponse> respostas = new ArrayList<>();
        if (resultado != null) {
            for (Cupom c : resultado) {
                CupomResponse r = new CupomResponse();
                r.setNumCupom(c.getNumCupom());
                r.setTituloCupom(c.getTituloCupom());
                r.setDtaEmissaoCupom(c.getDtaEmissaoCupom());
                r.setDtaInicioCupom(c.getDtaInicioCupom());
                r.setDtaTerminoCupom(c.getDtaTerminoCupom());
                if (c.getPerDescCupom() != null) {
                    BigDecimal valor = new BigDecimal(c.getPerDescCupom().toString());
                    r.setPerDescCupom(valor);
                } else {
                    r.setPerDescCupom(null);
                }
                r.setQntCupom(c.getQntCupom());
                respostas.add(r);
            }
        }
        return respostas;
    }
}

