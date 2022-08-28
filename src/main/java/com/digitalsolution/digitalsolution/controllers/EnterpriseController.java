package com.digitalsolution.digitalsolution.controllers;


import com.digitalsolution.digitalsolution.entityes.Enterprise;
import com.digitalsolution.digitalsolution.services.EnterpriseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Enterprise agregarEnterprise(@RequestBody Enterprise enterprise){

       return this.enterpriseService.crearEnterprise(enterprise);
    }

    /**
     * El sistema permite consultar una sola empresa
     * @param id
     */
    @GetMapping("/enterprise/{id}")
    public void obtenerInterprise(@PathVariable("id") Long id){

    }

    /**
     * El sistema permite editar una empresa
     * @param id
     */
    @PatchMapping("/enterprises/{nit}")
    public boolean actualizarInterprise(@PathVariable("nit") Long nit){

       return this.enterpriseService.actualizarEnterprise(nit);
    }

    /**
     * El sistema permite eliminar una empresa
     * @param id
     */
    @DeleteMapping("/enterprises/{id}")
    public void eliminarInterprise(@PathVariable("id") Long id){

    }



}
