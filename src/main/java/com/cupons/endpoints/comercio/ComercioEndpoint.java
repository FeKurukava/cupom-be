package com.cupons.endpoints.comercio;

import com.cupons.models.comercio.ComercioRequestBody;
import com.cupons.models.cupom.CupomRequestBody;
import com.cupons.models.cupom.CupomResponse;
import com.cupons.service.comercio.ComercioService;
import com.cupons.service.cupom.CupomService;
import com.cupons.utils.DocumentoUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/comercio")
@CrossOrigin(origins = "*")
public class ComercioEndpoint {

    private final ComercioService comercioService;
    private final CupomService cupomService;

    public ComercioEndpoint(ComercioService comercioService, CupomService cupomService) {
        this.comercioService = comercioService;
        this.cupomService = cupomService;
    }

    @PostMapping("/novo")
    public ResponseEntity<Void> novoComercio(@Valid @RequestBody ComercioRequestBody requestBody) {
        comercioService.novoComercio(requestBody);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/criar-cupom")
    public ResponseEntity<Void> criarCupom(@RequestBody @Valid CupomRequestBody cupomRequestBody) {
        comercioService.gerarCupom(cupomRequestBody);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity<List<CupomResponse>> listarCupons(
            @PathVariable String cnpj,
            @RequestParam String status
    ){
        List<CupomResponse> cupons = cupomService.listarCuponsPorCnpj(DocumentoUtils.limparDocumento(cnpj), status);
        return ResponseEntity.ok(cupons);
    }

    @PostMapping("/usar-cupom")
    public ResponseEntity<Void> usarCupom(@RequestParam String numCupom){
        comercioService.registrarUsoCupom(numCupom);
        return ResponseEntity.ok().build();
    }
}
