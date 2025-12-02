package com.cupons.endpoints.cupom;


import com.cupons.models.cupom.Cupom;
import com.cupons.service.comercio.ComercioService;
import com.cupons.service.cupom.CupomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cupom")
public class CupomEndpoint {

    private final CupomService cupomService;

    public CupomEndpoint(CupomService cupomService){
        this.cupomService = cupomService;
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity<List<Cupom>> listarCupons(
            @PathVariable String cnpj,
            @RequestParam String status
    ){
        List<Cupom> cupons = cupomService.listarCuponsPorCnpj(cnpj, status);
        return ResponseEntity.ok(cupons);
    }

}
