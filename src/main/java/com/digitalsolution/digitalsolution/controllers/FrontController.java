package com.digitalsolution.digitalsolution.controllers;

import com.digitalsolution.digitalsolution.entityes.Transaction;
import com.digitalsolution.digitalsolution.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class FrontController {

    @Autowired
    private TransactionService transactionService;


    @RequestMapping("/")
    public String inicio(Model model){

        model.addAttribute("saludo", "DigitalSoluti0n");
        return "index";
    }

    @GetMapping("/transactionsf/{enterprise}")
    public String transationEnterprise(@PathVariable("enterprise") Long enterprise, Model model){
        List<Transaction> transactionList = this.transactionService.obtenerTransactionEnterprise(enterprise);
        model.addAttribute("enterprise",transactionList);
        return "transaction";
    }

    @GetMapping("/transacti")//obtenre tod
    public String transationEnterprise(Model model){
        List<Transaction> transactionList = this.transactionService.obtenerTransaction();
        model.addAttribute("enterprise",transactionList);
        return "transaction";
    }

    @GetMapping("/transaction/create")
    public String transactionCreate(Model model){
        model.addAttribute("transac", new Transaction());

        return "createtransaction";
    }

}
