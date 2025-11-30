package com.cupons.service.auth;

import com.cupons.models.comercio.Comercio;
import com.cupons.models.auth.LoginRequest;
import com.cupons.models.auth.LoginResponse;
import com.cupons.repository.comercio.ComercioRepository;
import org.springframework.stereotype.Service;

import static com.cupons.utils.DocumentoUtils.limparDocumentoRetornarInteger;

@Service
public class LoginComercianteService {

    private final ComercioRepository comercioRepository;
    private final TokenService tokenService;

    public LoginComercianteService(ComercioRepository comercioRepository, TokenService tokenService) {
        this.comercioRepository = comercioRepository;
        this.tokenService = tokenService;
    }

    public LoginResponse login(LoginRequest request) {

        String cnpj = request.getCpf();

        Comercio c = comercioRepository.findById(limparDocumentoRetornarInteger(cnpj))
                .orElseThrow(() -> new IllegalArgumentException("Comerciante não encontrado."));

        if (!c.getSenComercio().equals(request.getSenha())) {
            throw new IllegalArgumentException("Senha incorreta.");
        }

        String payload = String.format(
                "{\"tipo\":\"comerciante\", \"cnpj\":\"%s\", \"email\":\"%s\", \"idUsuario\":\"%s\"}",
                c.getCnpjComercio(),
                c.getEmailComercio(),
                c.getCnpjComercio()
        );

        String token = tokenService.gerarToken(payload);

        return new LoginResponse(token);
    }
}
