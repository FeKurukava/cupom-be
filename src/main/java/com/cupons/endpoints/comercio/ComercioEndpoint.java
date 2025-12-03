package com.cupons.endpoints.comercio;

import com.cupons.models.comercio.ComercioLoginRequest;
import com.cupons.models.comercio.ComercioRequestBody;
import com.cupons.models.comercio.RecuperarSenhaComercioRequest;
import com.cupons.models.auth.LoginResponse;
import com.cupons.models.cupom.CupomRequestBody;
import com.cupons.models.cupom.CupomResponse;
import com.cupons.service.comercio.ComercioService;
import com.cupons.service.cupom.CupomService;
import com.cupons.service.auth.LoginComercianteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/comercio")
public class ComercioEndpoint {

    private final ComercioService comercioService;
    private final CupomService cupomService;
    private final LoginComercianteService loginComercianteService;

    public ComercioEndpoint(ComercioService comercioService, CupomService cupomService, LoginComercianteService loginComercianteService) {
        this.comercioService = comercioService;
        this.cupomService = cupomService;
        this.loginComercianteService = loginComercianteService;
    }

    @PostMapping("/novo")
    public ResponseEntity<Void> novoComercio(@Valid @RequestBody ComercioRequestBody requestBody) {
        comercioService.novoComercio(requestBody);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody ComercioLoginRequest request) {
        LoginResponse resposta = loginComercianteService.loginPorEmail(request);
        return ResponseEntity.ok(resposta);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestHeader("Authorization") String token) {
//        comercioService.logout(token);
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
        List<CupomResponse> cupons = cupomService.listarCuponsPorCnpj(cnpj, status);
        return ResponseEntity.ok(cupons);
    }

    @PostMapping("/usar-cupom")
    public ResponseEntity<Void> usarCupom(@RequestParam String numCupom){
        comercioService.registrarUsoCupom(numCupom);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/recuperar-senha")
    public ResponseEntity<Void> recuperarSenha(@RequestBody @Valid RecuperarSenhaComercioRequest request){
        comercioService.recuperarSenhaComercio(request);
        return ResponseEntity.ok().build();
    }
}
