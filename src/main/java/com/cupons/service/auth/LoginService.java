package com.cupons.service.auth;

import com.cupons.models.associado.Associado;
import com.cupons.models.auth.LoginRequest;
import com.cupons.models.auth.LoginResponse;
import com.cupons.models.auth.RecuperarSenhaAssociadoRequest;
import com.cupons.repository.associado.AssociadoRepository;
import org.springframework.stereotype.Service;

import static com.cupons.utils.DocumentoUtils.limparDocumento;

@Service
public class LoginService {

    private final AssociadoRepository associadoRepository;
    private final TokenService tokenService;

    public LoginService(AssociadoRepository associadoRepository, TokenService tokenService) {
        this.associadoRepository = associadoRepository;
        this.tokenService = tokenService;
    }

    public LoginResponse login(LoginRequest request) {


        Associado associado = associadoRepository.findById(limparDocumento(request.getCpf()))
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));

        if (!associado.getSenAssociado().equals(request.getSenha())) {
            throw new IllegalArgumentException("Senha incorreta.");
        }

        String payload = String.format(
                "{\"tipo\":\"associado\", \"cpf\":\"%s\", \"email\":\"%s\", \"idUsuario\":\"%s\"}",
                associado.getCpfAssociado(),
                associado.getEmailAssociado(),
                associado.getCpfAssociado()
        );

        String token = tokenService.gerarToken(payload);

        return new LoginResponse(token);
    }

    public void recuperarSenhaAssociado(RecuperarSenhaAssociadoRequest request) {
        Associado associado = associadoRepository.findById(limparDocumento(request.getCpf()))
                .orElseThrow(() -> new IllegalArgumentException("Associado não encontrado."));
        associado.setSenAssociado(request.getNovaSenha());
        associadoRepository.save(associado);
    }
}
