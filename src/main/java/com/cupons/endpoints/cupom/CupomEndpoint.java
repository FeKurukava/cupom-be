package com.cupons.endpoints.cupom;

import com.cupons.models.comercio.Comercio;
import com.cupons.models.cupom.CupomCadastroRequest;
import com.cupons.models.cupom.RegistrarUsoCupomRequest;
import com.cupons.repository.comercio.ComercioRepository;
import com.cupons.service.cupom.CupomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cupons")
@CrossOrigin(origins = "*")
public class CupomEndpoint {

    private final CupomService cupomService;
    private final ComercioRepository comercioRepository;

    public CupomEndpoint(CupomService cupomService,
                         ComercioRepository comercioRepository) {
        this.cupomService = cupomService;
        this.comercioRepository = comercioRepository;
    }
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody CupomCadastroRequest request) {

        Comercio comercio = comercioRepository.findById(request.getCnpjComercio())
                .orElseThrow(() -> new IllegalArgumentException("Comerciante não encontrado"));

        cupomService.cadastrarCupons(request, comercio);

        return ResponseEntity.ok("Cupons gerados com sucesso.");
    }

    @PostMapping("/registrar-uso")
    public ResponseEntity<?> registrarUso(@RequestBody RegistrarUsoCupomRequest request) {
        cupomService.registrarUso(request.getNumCupom());
        return ResponseEntity.ok("Uso do cupom registrado com sucesso.");
    }



}
