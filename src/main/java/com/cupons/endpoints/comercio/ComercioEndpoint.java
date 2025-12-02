package com.cupons.endpoints.comercio;

import com.cupons.models.comercio.ComercioLoginRequest;
import com.cupons.models.comercio.ComercioRequestBody;
import com.cupons.models.cupom.Cupom;
import com.cupons.models.cupom.CupomRequestBody;
import com.cupons.service.comercio.ComercioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/comercio")
public class ComercioEndpoint {

    private final ComercioService comercioService;

    public ComercioEndpoint(ComercioService comercioService) {
        this.comercioService = comercioService;
    }

    // Cadastro
    @PostMapping("/novo")
    public ResponseEntity<Void> novoComercio(@Valid @RequestBody ComercioRequestBody requestBody) {
        comercioService.novoComercio(requestBody);
        return ResponseEntity.ok().build();
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody ComercioLoginRequest request) {
//        String token = comercioService.login(request.getEmail(), request.getSenha());
        return ResponseEntity.ok("");
    }

    // Logout
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestHeader("Authorization") String token) {
//        comercioService.logout(token);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/criar-cupom")
    public ResponseEntity<Void> criarCupom(@RequestBody CupomRequestBody cupomRequestBody) {
        comercioService.gerarCupom(cupomRequestBody);

        return ResponseEntity.ok().build();
    }
}
