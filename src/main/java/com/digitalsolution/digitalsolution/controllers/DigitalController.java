package com.digitalsolution.digitalsolution.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DigitalController {

    @RequestMapping("/")
    public String inicio(Model model){

        model.addAttribute("saludo", "DigitalSoluti0n_tre");
        return "index";
    }
}
