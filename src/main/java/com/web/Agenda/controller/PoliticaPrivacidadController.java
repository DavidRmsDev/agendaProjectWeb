package com.web.Agenda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PoliticaPrivacidadController {

    @RequestMapping("/Privacidad")
    public String listarNotas() {
        return "politicaSeguridad";
    }
}
