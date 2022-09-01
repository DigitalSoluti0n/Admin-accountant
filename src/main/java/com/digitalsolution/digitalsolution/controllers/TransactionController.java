package com.digitalsolution.digitalsolution.controllers;


import com.digitalsolution.digitalsolution.entityes.Transaction;
import com.digitalsolution.digitalsolution.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    /**
     * El sistema permite consultar todas las transacciones
     */
    @GetMapping("/transactions")
    public List<Transaction> obtenerTransaction(){

        return this.transactionService.obtenerTransaction();
    }

    /**
     * El sistema permite crear una transacción
     */
    @PostMapping("/transaction")
    public boolean agregarTransaction(@RequestBody Transaction transaction){

        return this.transactionService.crearTransaction(transaction);
    }

    /**
     * El sistema permite consultar una sola transacción
     *
     *
     */
    @GetMapping("/transaction/{idm}")
    public Optional<Transaction> obtenerTransaction(@PathVariable("idm") Long idm){

        return this.transactionService.obtenerTransaction(idm);
    }

    /**
     * El sistema permite editar una transacción
     *
     */
    @PatchMapping("/transaction/{idm}")
    public String actualizarTransaction(@RequestBody Transaction transaction, @PathVariable("idm") Long idm){

        if (this.transactionService.actualizarTransaction(transaction, idm)){
            return "correcto";
        }

        return "incorrecto";
    }

    /**
     * El sistema permite eliminar una transacción
     *
     */
    @DeleteMapping("/transaction/{idm}")
    public boolean eliminarTransaction(@PathVariable("idm") Long idm){

        return this.transactionService.eliminarTransaction(idm);
    }

    /**
     * El sistema permite consultar una sola transacción por columna determinada
     */
    @GetMapping("/transactionEnterprise/{enterprise}")
    public List<Transaction> consultarTransactionEnterprise(@PathVariable("enterprise") Long enterprise){
        return this.transactionService.obtenerTransactionEnterprise(enterprise);
    }


}
