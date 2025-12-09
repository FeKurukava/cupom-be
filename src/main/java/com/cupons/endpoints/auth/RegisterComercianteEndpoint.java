package com.cupons.endpoints.auth;

import com.cupons.models.comercio.Comercio;
import com.cupons.repository.comercio.ComercioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/register")
@CrossOrigin(origins = "*")
public class RegisterComercianteEndpoint {

    private final ComercioRepository comercioRepository;

    public RegisterComercianteEndpoint(ComercioRepository comercioRepository) {
        this.comercioRepository = comercioRepository;
    }

    @PostMapping("/comerciante")
    public ResponseEntity<?> register(@RequestBody Comercio request) {

        if (comercioRepository.existsById(request.getCnpjComercio())) {
            return ResponseEntity.badRequest().body("CNPJ já cadastrado.");
        }

        if (!request.getEmailComercio().contains("@")) {
            return ResponseEntity.badRequest().body("E-mail inválido.");
        }

        comercioRepository.save(request);

        return ResponseEntity.ok("Comerciante cadastrado com sucesso.");
    }
}
