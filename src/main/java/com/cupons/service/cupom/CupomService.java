package com.cupons.service.cupom;

import com.cupons.models.comercio.Comercio;
import com.cupons.models.cupom.Cupom;
import com.cupons.models.cupom.CupomRequestBody;
import com.cupons.models.cupom.StatusCupom;
import com.cupons.repository.comercio.ComercioRepository;
import com.cupons.repository.cupom.CupomRepository;
import com.cupons.service.comercio.ComercioService;
import com.cupons.utils.DocumentoUtils;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class CupomService {

    private final CupomRepository cupomRepository;

    public CupomService(CupomRepository cupomRepository) {
        this.cupomRepository = cupomRepository;
    }

    public List<Cupom> listarCuponsPorCnpj(String cnpj, String status) {

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
        return resultado;
    }
}

