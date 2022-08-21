package com.digitalsolution.digitalsolution.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GestionController {

    @RequestMapping("/")
    public String login(Model model){

        model.addAttribute("saludo", "BIENVENIDOS A DigitalSoluti0n");
        return "index";
    }

}
