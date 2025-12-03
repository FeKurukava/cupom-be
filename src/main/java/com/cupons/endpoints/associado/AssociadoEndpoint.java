package com.cupons.endpoints.associado;

import com.cupons.models.comercio.ComercioResponse;
import com.cupons.models.associado.AssociadoRequestBody;
import com.cupons.models.cupom.CupomResponse;
import com.cupons.models.cupom.ReservarCupomRequest;
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

    @GetMapping("/comercios")
    public ResponseEntity<java.util.List<ComercioResponse>> listarComercios(){
        java.util.List<ComercioResponse> lista = associadoService.listarComercios();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/comercios/{cnpj}/cupons")
    public ResponseEntity<java.util.List<CupomResponse>> listarCuponsPorComercio(@PathVariable String cnpj, @RequestParam(required = false) String status){
        String filtro = status == null ? "ATIVOS" : status;
        java.util.List<CupomResponse> lista = associadoService.listarCuponsPorCnpj(cnpj, filtro);
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/reservar-cupom")
    public ResponseEntity<Void> reservarCupom(@RequestBody @Valid ReservarCupomRequest request){
        associadoService.reservarCupom(request);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/meus-cupons")
    public ResponseEntity<java.util.List<CupomResponse>> meusCupons(@RequestParam String cpf, @RequestParam String status){
        java.util.List<CupomResponse> lista = associadoService.buscarCuponsAssociado(cpf, status);
        return ResponseEntity.ok(lista);
    }
}
