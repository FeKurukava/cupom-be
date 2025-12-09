package com.cupons.endpoints.auth;

import com.cupons.models.auth.LoginRequest;
import com.cupons.models.auth.LoginResponse;
import com.cupons.models.comercio.ComercioLoginRequest;
import com.cupons.service.auth.LoginComercianteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/login-email")
    public ResponseEntity<LoginResponse> loginPorEmail(@RequestBody ComercioLoginRequest request) {
        LoginResponse response = loginComercianteService.loginPorEmail(request);
        return ResponseEntity.ok(response);
    }
}
