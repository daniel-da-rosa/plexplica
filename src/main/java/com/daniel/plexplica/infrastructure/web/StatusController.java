package com.daniel.plexplica.infrastructure.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
    @GetMapping("/status")
    public String status() {
        return "🔵 Plexplica tá ON!";
    }


}
