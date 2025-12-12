package com.cupons.endpoints.auth;

import com.cupons.models.auth.LoginRequest;
import com.cupons.models.auth.LoginResponse;
import com.cupons.models.comercio.RecuperarSenhaComercioRequest;
import com.cupons.service.auth.LoginComercianteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth/comerciante")
@CrossOrigin(origins = "*")
public class LoginComercianteEndpoint {

    private final LoginComercianteService loginComercianteService;

    public LoginComercianteEndpoint(LoginComercianteService loginComercianteService) {
        this.loginComercianteService = loginComercianteService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        LoginResponse response = loginComercianteService.login(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/recuperar-senha")
    public ResponseEntity<Void> recuperarSenha(@RequestBody @Valid RecuperarSenhaComercioRequest request){
        loginComercianteService.recuperarSenhaComercio(request);
        return ResponseEntity.ok().build();
    }
}
