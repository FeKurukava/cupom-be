package com.cupons.endpoints.auth;

import com.cupons.service.auth.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LogoutEndpoint {

    private final TokenService tokenService;

    public LogoutEndpoint(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String token) {

        // Remover o prefixo "Bearer " caso o front envie assim
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        if (!tokenService.tokenValido(token)) {
            return ResponseEntity.status(400).body("Token inválido ou já expirado.");
        }

        tokenService.invalidarToken(token);

        return ResponseEntity.ok("Logout realizado com sucesso.");
    }
}
