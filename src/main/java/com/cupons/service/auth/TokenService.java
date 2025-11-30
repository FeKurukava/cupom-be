package com.cupons.service.auth;

import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

@Service
public class TokenService {

    private final Set<String> tokensAtivos = new HashSet<>();

    public String gerarToken(String payload) {
        String token = Base64.getEncoder().encodeToString(payload.getBytes());
        tokensAtivos.add(token);
        return token;
    }

    public boolean tokenValido(String token) {
        return tokensAtivos.contains(token);
    }

    public void invalidarToken(String token) {
        tokensAtivos.remove(token);
    }
}
