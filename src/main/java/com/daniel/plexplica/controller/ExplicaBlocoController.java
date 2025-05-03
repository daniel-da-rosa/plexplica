package com.daniel.plexplica.controller;

import com.daniel.plexplica.domain.DTO.BlocoExplicacaoDTO;
import com.daniel.plexplica.domain.DTO.ExplicacaoRequestDTO;
import com.daniel.plexplica.service.ExplicacaoService;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/explicar")
@RequiredArgsConstructor
public class ExplicaBlocoController {

    private final ExplicacaoService explicacaoService;

    @PostMapping(consumes = "text/plain", produces = "application/json")
    public BlocoExplicacaoDTO explicar(@RequestBody String sql){
        return explicacaoService.explicaBloco(sql);
    }

}
