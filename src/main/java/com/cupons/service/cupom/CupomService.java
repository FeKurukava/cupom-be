package com.cupons.service.cupom;

import com.cupons.models.comercio.Comercio;
import com.cupons.models.cupom.Cupom;
import com.cupons.models.cupom.CupomCadastroRequest;
import com.cupons.models.cupom.CupomResponse;
import com.cupons.models.cupom.StatusCupom;
import com.cupons.repository.cupom.CupomRepository;
import com.cupons.utils.DocumentoUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CupomService {

    private final CupomRepository cupomRepository;
    private static final String ALFABETO = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    public CupomService(CupomRepository cupomRepository) {
        this.cupomRepository = cupomRepository;
    }

    public void cadastrarCupons(CupomCadastroRequest request, Comercio comercio) {

        LocalDate inicio = request.getDataInicio();
        LocalDate fim = request.getDataFim();

        if (inicio.isAfter(fim)) {
            throw new IllegalArgumentException("Data de início não pode ser após a data de término.");
        }

        if (request.getQuantidade() == null || request.getQuantidade() <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        }

        List<Cupom> lista = new ArrayList<>();

        for (int i = 0; i < request.getQuantidade(); i++) {
            Cupom c = new Cupom();
            c.setNumCupom(gerarCodigoAleatorio());
            c.setComercio(comercio);
            c.setTituloCupom(request.getTitulo());

            c.setDtaEmissaoCupom(new Date()); // java.util.Date
            c.setDtaInicioCupom(java.sql.Date.valueOf(inicio));
            c.setDtaTerminoCupom(java.sql.Date.valueOf(fim));

            c.setPerDescCupom(BigDecimal.valueOf(request.getPercentualDesconto()));
            c.setQntCupom(request.getQuantidade());

            lista.add(c);
        }

        cupomRepository.saveAll(lista);
    }

    private String gerarCodigoAleatorio() {
        StringBuilder sb = new StringBuilder(12);
        for (int i = 0; i < 12; i++) {
            sb.append(ALFABETO.charAt(RANDOM.nextInt(ALFABETO.length())));
        }
        return sb.toString();
    }

    public List<CupomResponse> listarCuponsPorCnpj(String cnpj, String status) {

        String cnpjLimpo = DocumentoUtils.limparDocumento(cnpj);

        StatusCupom filtro;
        try {
            filtro = StatusCupom.valueOf(status.toUpperCase());
        } catch (Exception e) {
            throw new RuntimeException("Status inválido. Use: ATIVOS, VENCIDOS ou UTILIZADOS.");
        }

        List<Cupom> resultado = switch (filtro) {
            case ATIVOS -> cupomRepository.findAtivosByCnpj(cnpjLimpo);
            case VENCIDOS -> cupomRepository.findVencidosByCnpj(cnpjLimpo);
            case UTILIZADOS -> cupomRepository.findUtilizadosByCnpj(cnpjLimpo);
        };

        List<CupomResponse> respostas = new ArrayList<>();
        for (Cupom c : resultado) {
            CupomResponse r = new CupomResponse();
            r.setNumCupom(c.getNumCupom());
            r.setTituloCupom(c.getTituloCupom());
            r.setDtaEmissaoCupom(c.getDtaEmissaoCupom());
            r.setDtaInicioCupom(c.getDtaInicioCupom());
            r.setDtaTerminoCupom(c.getDtaTerminoCupom());
            r.setPerDescCupom(c.getPerDescCupom() != null
                    ? new BigDecimal(c.getPerDescCupom().toString())
                    : null);
            r.setQntCupom(c.getQntCupom());
            respostas.add(r);
        }

        return respostas;
    }
}
