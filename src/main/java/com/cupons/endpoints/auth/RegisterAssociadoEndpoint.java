package com.cupons.endpoints.auth;

import com.cupons.models.associado.Associado;
import com.cupons.repository.associado.AssociadoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/register")
@CrossOrigin(origins = "*")
public class RegisterAssociadoEndpoint {

    private final AssociadoRepository associadoRepository;

    public RegisterAssociadoEndpoint(AssociadoRepository associadoRepository) {
        this.associadoRepository = associadoRepository;
    }

    @PostMapping("/associado")
    public ResponseEntity<?> register(@RequestBody Associado request) {

        if (associadoRepository.existsById(request.getCpfAssociado())) {
            return ResponseEntity.badRequest().body("CPF já cadastrado.");
        }

        if (!request.getEmailAssociado().contains("@")) {
            return ResponseEntity.badRequest().body("E-mail inválido.");
        }

        associadoRepository.save(request);

        return ResponseEntity.ok("Associado cadastrado com sucesso.");
    }
}
