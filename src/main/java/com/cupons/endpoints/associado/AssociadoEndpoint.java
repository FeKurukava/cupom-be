package com.cupons.endpoints.associado;

import com.cupons.models.associado.AssociadoRequestBody;
import com.cupons.service.associado.AssociadoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/associado")
public class AssociadoEndpoint {

    private final AssociadoService associadoService;

    public AssociadoEndpoint(AssociadoService associadoService) {
        this.associadoService = associadoService;
    }

    @PostMapping("/novo-usuario")
    public ResponseEntity<Void> novoUsuario(@RequestBody @Valid AssociadoRequestBody associadoRequestBody){
        associadoService.novoUsuario(associadoRequestBody);
        return ResponseEntity.status(201).build();
    }
}
