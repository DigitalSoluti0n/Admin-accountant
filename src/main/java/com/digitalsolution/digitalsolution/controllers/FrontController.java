package com.digitalsolution.digitalsolution.controllers;

import com.digitalsolution.digitalsolution.entityes.Employee;
import com.digitalsolution.digitalsolution.entityes.Enterprise;
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

        transactionList.stream().forEach(System.out::println);

        model.addAttribute("enterprise",transactionList);
        return "transaction";
    }

    @GetMapping("/transacti")//obtenre todos pero se debe realizar solo para la empresa {enterprise}
    public String transationEnterprise(Model model){
        List<Transaction> transactionList = this.transactionService.obtenerTransaction();
        model.addAttribute("enterprise",transactionList);
        return "transaction";
    }

    @GetMapping("/transaction/create")//crear transaccion o ingreso
    public String transactionCreate(Model model){
        model.addAttribute("transac", new Transaction());

        return "createtransaction";
    }

    @GetMapping("/transacti/egreso")//crear egreso
    public String transactionEgreso(Model model){
        model.addAttribute("transae", new Transaction());

        return "registroegreso";
    }

    @GetMapping("/enterprise/create")//crear empresa
    public String enterpriseCreate(Model model){
        model.addAttribute("entercreate", new Enterprise());

        return "registroenter";
    }

    @GetMapping("/usercreate")//crear user
    public String userCreate(Model model){
        model.addAttribute("user", new Employee());

        return "registrouser";
    }




    @GetMapping( "/login")//es para login
    public String iniciarSesion( ){

           // model.addAttribute("inic", new Employee());

        return "login";
    }


    @PostMapping("/login")
    public String iniciarConten(@ModelAttribute(name = "inic") Employee employee, Model model){
        
        if (employee.getCedula() != 0 && employee.getContra() != ""){

            Optional<Employee> employee1 = this.employeeService.buscarEmployee(employee.getCedula());

        if (employee1.isPresent()){

                if (employee1.get().getContra().equals(employee.getContra())){


                    model.addAttribute("hola", employee1.get().getEnterprise());

                    return "index";
                }
                
                else{
                    model.addAttribute("error", "incorrect dat");
                    return "login";
                }

        }else{
                model.addAttribute("error", "incorrect dat");
                return "login";
            }



        }else{
            model.addAttribute("error", "incorrect dat");
            return "login";
        }
        
    }

}
