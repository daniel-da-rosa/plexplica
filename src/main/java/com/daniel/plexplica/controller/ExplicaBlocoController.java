package com.daniel.plexplica.controller;

import com.daniel.plexplica.domain.modelo.Bloco;
import com.daniel.plexplica.service.ExplicacaoService;

import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/explicar")
public class ExplicaBlocoController {

    private final ExplicacaoService service;

    public ExplicaBlocoController(ExplicacaoService service) {
        this.service = service;
    }

    @GetMapping("/{tipo}")
    public String explicar(@PathVariable String tipo) {
        Bloco bloco = new Bloco(tipo, "Conteúdo de teste");
        return service.explicarBloco(bloco);
    }
}
