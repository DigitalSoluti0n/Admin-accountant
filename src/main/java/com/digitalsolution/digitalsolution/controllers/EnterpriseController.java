package com.digitalsolution.digitalsolution.controllers;


import com.digitalsolution.digitalsolution.entityes.Enterprise;
import com.digitalsolution.digitalsolution.services.EnterpriseService;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@RestController
public class EnterpriseController {
 EnterpriseService enterpriseService;


  public EnterpriseController(EnterpriseService service){

     this.enterpriseService = service;
  }

    /**
     * El sistema permite consultar todas las empresas 
     */
    @GetMapping("/enterprises")
    public List<Enterprise> obtenerEnterprise(){

    return this.enterpriseService.obtenerEnterprise();
    }

   /**
    * El sistema permite crear una empresa
    */
   @PostMapping("/enterprises")
    public RedirectView agregarEnterprise(@ModelAttribute @DateTimeFormat(pattern = "YYYY-MM-DD") Enterprise enterprise, Model model){

        model.addAttribute(enterprise);
        this.enterpriseService.crearEnterprise(enterprise);

        return new RedirectView("/transacti");

    }

    /**
     * El sistema permite consultar una sola empresa
     *
     * @param id
     */
    @GetMapping("/enterprises/{id}")
    public Optional<Enterprise> obtenerInterprise(@PathVariable("id") Long id){

        return this.enterpriseService.obtenerUnaEnterprise(id);
    }

    /**
     * El sistema permite editar una empresa
     * @param id
     */
    @PatchMapping("/enterprises/{id}")
    public String actualizarInterprise(@RequestBody Enterprise enterprise, @PathVariable("id") Long id){

        if (this.enterpriseService.actualizarEnterprise(enterprise, id)){
            return "correcto";
        }

       return "incorrecto";
    }

    /**
     * El sistema permite eliminar una empresa
     * @param id
     */
    @DeleteMapping("/enterprises/{id}")
    public boolean eliminarInterprise(@PathVariable("id") Long id){

        return this.enterpriseService.eliminarEnterprise(id);
    }


    /**
     * El sistema permite consultar una sola empresa por documento
     */
    @GetMapping("/enterpriseDocument/{document}")
    public List<Enterprise> consultarEnterpriseDocument(@PathVariable("document") String document){
        return this.enterpriseService.obtenerEnterpriseDocument(document);
    }

}
