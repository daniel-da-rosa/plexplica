package com.daniel.plexplica.controller;

import com.daniel.plexplica.domain.DTO.BlocoExplicacaoDTO;
import com.daniel.plexplica.domain.DTO.ExplicacaoRequestDTO;
import com.daniel.plexplica.service.ExplicacaoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/explicar")
public class ExplicaBlocoController {

    private final ExplicacaoService explicacaoService;

    public ExplicaBlocoController(ExplicacaoService explicacaoService) {

        this.explicacaoService = explicacaoService;
    }

    @PostMapping
    public BlocoExplicacaoDTO explicar(@RequestBody ExplicacaoRequestDTO request){
        return explicacaoService.explicaBloco(request);
    }

}
