package com.digitalsolution.digitalsolution.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class EnterpriseController {

 @GetMapping("/enterprises")
 public void obtenerEnterprise(){

 }
 @PostMapping("/enterprises")
 public void agregarEnterprise(){

 }

 @GetMapping("/enterprises/{id}")
 public void obtenerInterprise(@PathVariable("id") Long id){

 }

 @PatchMapping("/enterprises/{id}")
 public void actualizarInterprise(@PathVariable("id") Long id){

 }

 @DeleteMapping("/enterprises/{id}")
 public void eliminarInterprise(@PathVariable("id") Long id){

 }



}
