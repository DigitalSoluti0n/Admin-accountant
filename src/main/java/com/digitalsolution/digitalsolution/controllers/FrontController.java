package com.digitalsolution.digitalsolution.controllers;

import com.digitalsolution.digitalsolution.entityes.Employee;
import com.digitalsolution.digitalsolution.entityes.Transaction;
import com.digitalsolution.digitalsolution.services.EmployeeService;
import com.digitalsolution.digitalsolution.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class FrontController {

    @Autowired
    private TransactionService transactionService;
    @Autowired
    private EmployeeService    employeeService;


    @GetMapping("/")//index
    public String inicio(Model model){

        return "index";
    }

    @GetMapping("/transactionsf/{enterprise}")//consultar transaccion prar empresa
    public String transationEnterprise(@PathVariable("enterprise") Long enterprise, Model model){
        List<Transaction> transactionList = this.transactionService.obtenerTransactionEnterprise(enterprise);
        model.addAttribute("enterprise",transactionList);
        return "transaction";
    }

    @GetMapping("/transacti")//obtenre todoa
    public String transationEnterprise(Model model){
        List<Transaction> transactionList = this.transactionService.obtenerTransaction();
        model.addAttribute("enterprise",transactionList);
        return "transaction";
    }

    @GetMapping("/transaction/create")//crear transaccion
    public String transactionCreate(Model model){
        model.addAttribute("transac", new Transaction());

        return "createtransaction";
    }

    @GetMapping( "/login")//es para login
    public String iniciarSesion( Model  model){

            model.addAttribute("inic", new Employee());

        return "login";
    }


    @GetMapping("/loginveri")
    public String iniciarConten(@ModelAttribute Employee employee, Model model){

        if (this.employeeService.buscarEmployee(employee.getCedula()).isPresent()){
            model.addAttribute("hola", employee.getCedula());
            System.out.println(employee.getCedula());
            return "index";
        }
    return "error";
    }
}
