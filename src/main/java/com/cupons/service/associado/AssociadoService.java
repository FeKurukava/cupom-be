package com.cupons.service.associado;

import com.cupons.models.associado.Associado;
import com.cupons.models.associado.AssociadoRequestBody;
import com.cupons.repository.associado.AssociadoRepository;
import com.cupons.utils.DocumentoUtils;
import org.springframework.stereotype.Service;

@Service
public class AssociadoService {

    private final AssociadoRepository associadoRepository;

    public AssociadoService(AssociadoRepository associadoRepository) {
        this.associadoRepository = associadoRepository;
    }

    public Associado novoUsuario(AssociadoRequestBody requestBody){

        Associado associado = new Associado();

        associado.setCpfAssociado(DocumentoUtils.limparDocumentoRetornarLong(requestBody.getCpfAssociado()));
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


}
