package com.daniel.plexplica.infrastructure.web;

import com.daniel.plexplica.service.ExplicacaoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/explicar")
public class ExpliicacaoBlocoController {

    private final ExplicacaoService service;

    public ExpliicacaoBlocoController(ExplicacaoService service){
        this.service = service;
    }

    @PostMapping
    public String explicar(@RequestBody String codigoSql){
        return service.explicacaoCodigo(codigoSql);
    }

}
