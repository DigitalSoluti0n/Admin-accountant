package com.digitalsolution.digitalsolution.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {

    @GetMapping("/enterprises/{id}/movements")
    public void obtenerTransaction(){

    }
    @PostMapping("/enterprises/{id}/movements")
    public void agregarTransaction(){

    }

    @PatchMapping("/enterprises/{id}/movements")
    public void actualizarTransaction(@PathVariable("id") Long id){

    }

    @DeleteMapping("/enterprises/{id}/movements")
    public void eliminarTransaction(@PathVariable("id") Long id){

    }

}
