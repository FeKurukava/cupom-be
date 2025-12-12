package com.cupons.endpoints.auth;

import com.cupons.models.auth.LoginRequest;
import com.cupons.models.auth.LoginResponse;
import com.cupons.models.auth.RecuperarSenhaAssociadoRequest;
import com.cupons.service.auth.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class LoginAssociadoEndpoint {

    private final LoginService loginService;

    public LoginAssociadoEndpoint(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        LoginResponse response = loginService.login(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/recuperar-senha")
    public ResponseEntity<Void> recuperarSenha(@RequestBody @Valid RecuperarSenhaAssociadoRequest request){
        loginService.recuperarSenhaAssociado(request);
        return ResponseEntity.ok().build();
    }
}
