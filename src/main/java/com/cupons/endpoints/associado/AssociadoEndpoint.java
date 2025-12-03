package com.cupons.endpoints.associado;

import com.cupons.models.comercio.ComercioResponse;
import com.cupons.models.associado.AssociadoRequestBody;
import com.cupons.models.cupom.CupomResponse;
import com.cupons.models.cupom.ReservarCupomRequest;
import com.cupons.models.auth.LoginRequest;
import com.cupons.models.auth.LoginResponse;
import com.cupons.models.auth.RecuperarSenhaAssociadoRequest;
import com.cupons.service.associado.AssociadoService;
import com.cupons.service.auth.LoginService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/associado")
    public class AssociadoEndpoint {

    private final AssociadoService associadoService;
    private final LoginService loginService;

    public AssociadoEndpoint(AssociadoService associadoService, LoginService loginService) {
        this.associadoService = associadoService;
        this.loginService = loginService;
    }

    @PostMapping("/novo-usuario")
    public ResponseEntity<Void> novoUsuario(@RequestBody @Valid AssociadoRequestBody associadoRequestBody){
        associadoService.novoUsuario(associadoRequestBody);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
        LoginResponse resposta = loginService.login(request);
        return ResponseEntity.ok(resposta);
    }

    @PostMapping("/recuperar-senha")
    public ResponseEntity<Void> recuperarSenha(@RequestBody @Valid RecuperarSenhaAssociadoRequest request){
        associadoService.recuperarSenhaAssociado(request);
        return ResponseEntity.ok().build();
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
