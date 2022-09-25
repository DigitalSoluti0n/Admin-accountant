package com.digitalsolution.digitalsolution.controllers;

import com.digitalsolution.digitalsolution.entityes.Employee;
import com.digitalsolution.digitalsolution.entityes.Enterprise;
import com.digitalsolution.digitalsolution.entityes.Transaction;
import com.digitalsolution.digitalsolution.services.EmployeeService;
import com.digitalsolution.digitalsolution.services.EnterpriseService;
import com.digitalsolution.digitalsolution.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class FrontController {

    private long enterprise ;
    private long cedula;
    private  String nombre;

    @Autowired
    private TransactionService transactionService;
    @Autowired
    private EmployeeService    employeeService;

    @Autowired
    private EnterpriseService enterpriseService;

    @GetMapping("/")//index
    public String inicio(Model model){

        return "index";
    }

    @GetMapping("/operacion")
    public String operacion(){

        return "operacion";
        
    }

    @GetMapping("/transactionsf/{enterprise}")//consultar transaccion prar empresa
    public String transationEnterprise(@PathVariable("enterprise") Long enterprise, Model model){
        List<Transaction> transactionList = this.transactionService.obtenerTransactionEnterprise(enterprise);

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
        model.addAttribute("cedula", cedula);
        model.addAttribute("enterprise", enterprise);
        model.addAttribute("hola", nombre);
        //System.out.println(enterprise);
        return "createtransaction";
    }

    @GetMapping("/transacti/egreso")//crear egreso
    public String transactionEgreso(Model model){
        model.addAttribute("transae", new Transaction());
       
        model.addAttribute("cedula", cedula);
        model.addAttribute("enterprise", enterprise);
        model.addAttribute("hola", nombre);
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
    @PostMapping("/transactionse")//REQUESTBODY = MODELATTRIBUTE para crear la transacción ingreso o egreso
    public String  agregarTransaction(@ModelAttribute @DateTimeFormat(pattern = "YYYY-MM-DD") Transaction transaction, Model model){
        
      //  System.out.println(enterprise);
        transaction.setEnterprise(enterprise);
        transaction.setUsuario(cedula);
        this.transactionService.crearTransaction(transaction);
       /// System.out.println(cedula);
        Optional<Employee> emplo = this.employeeService.buscarEmployee(cedula);
        List<Transaction> transactionList = this.transactionService.obtenerTransactionEnterprise(emplo.get().getEnterprise());

        double total = 0.0;
        for (Transaction transacti : transactionList) {
            total+=transacti.getAmount();
        }


        model.addAttribute("total", total);
        //if(emplo.isPresent()){
            model.addAttribute("ent", transactionList);
        //}

           model.addAttribute("cedula", transaction.getUsuario());

        return "egreingreso";

    }

    @GetMapping( "/egreingreso/{cedula}")//es para egreso e ingreso
    public String adminEgreIngreso(@PathVariable("cedula") Long cedula, Model model ){

        Optional<Employee> emplo = this.employeeService.buscarEmployee(cedula);
        List<Transaction> transactionList = this.transactionService.obtenerTransactionEnterprise(emplo.get().getEnterprise());

        double total = 0.0;
        for (Transaction transaction : transactionList) {
            total+=transaction.getAmount();
        }

        model.addAttribute("total", total);
        //if(emplo.isPresent()){
            model.addAttribute("ent", transactionList);
        //}
            model.addAttribute("hola", nombre);
           model.addAttribute("ced", cedula);

        return "egreingreso";
    }


    @GetMapping( "/login")//es para login
    public String iniciarSesion( ){

           // model.addAttribute("inic", new Employee());

        return "login";
    }

    /**
     * El sistema permite crear una empresa
     */
    @PostMapping("/enterprisesf")
    public RedirectView agregarEnterprise(@ModelAttribute @DateTimeFormat(pattern = "YYYY-MM-DD") Enterprise enterprise, Model model){

        if(this.enterpriseService.crearEnterprise(enterprise)){
            this.enterprise = enterprise.getNit();
            System.out.println(enterprise.getNit());
            model.addAttribute("ent",enterprise);
            return new RedirectView("/usercreate");
        }

        return new RedirectView("/enterprise/create");

    }

    /**
     * El sistema permite crear un usuario
     *
     * @return
     */
    @PostMapping("/usersf")
    public RedirectView agregarEmployee(@RequestParam(value = "contrat") String contra,  @ModelAttribute Employee employee, Model model){

        employee.setEnterprise(enterprise);
        if (employee.getContra().equals(contra)){
            if (this.employeeService.crearEmployee(employee)){

                return new RedirectView("/login");
            }
        }
        model.addAttribute("erroru", "datos incorrectos");//crear un front controller para enviar el error
        return new RedirectView("/usercreate");
    }

    @PostMapping("/login")
    public String iniciarConten(@ModelAttribute(name = "inic") Employee employee, Model model){
        
        if (employee.getCedula() != 0 && employee.getContra() != ""){

            Optional<Employee> employee1 = this.employeeService.buscarEmployee(employee.getCedula());

        if (employee1.isPresent()){

                if (employee1.get().getContra().equals(employee.getContra())){

                    List<Transaction> transactionList = this.transactionService.obtenerTransactionEnterprise(employee1.get().getEnterprise());
            
                    double total = 0.0;
                    for (Transaction transaction : transactionList) {
                        total+=transaction.getAmount();
                    }
            
                    model.addAttribute("total", total);
                    //if(emplo.isPresent()){
                        model.addAttribute("enterprise", transactionList);
                    //}


            
                     enterprise = employee1.get().getEnterprise();
                    cedula = employee1.get().getCedula();
                        nombre = employee1.get().getName();

                    model.addAttribute("enter", employee1.get().getEnterprise());//tomar decisión de acuerdo al rol
                    model.addAttribute("hola", employee1.get().getName());//tomar decisión de acuerdo al rol
                    model.addAttribute("cedula", employee1.get().getCedula());//tomar decisión de acuerdo al rol
                    //System.out.println(employee1.get().getRole()); 
                    
                    if(employee1.get().getRole().equals("administrador")){
                        return "operacion";
                    }else{
                        return "egreingreso";
                    }
                    
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
