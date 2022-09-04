package com.digitalsolution.digitalsolution.controllers;

import com.digitalsolution.digitalsolution.entityes.Employee;
import com.digitalsolution.digitalsolution.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

        @Autowired
       private EmployeeService employeeService;

        /**
         * El sistema permite consultar todos los usuarios
         *
         * @return
         */
        @GetMapping("/users")
        public List<Employee> obtenerEmployee(){

                return this.employeeService.listEmployee();
        }

        /**
         * El sistema permite crear un usuario
         *
         * @return
         */
        @PostMapping("/users")
        public boolean agregarEmployee(@RequestBody Employee employee){

        return this.employeeService.crearEmployee(employee);
        }

        /**
         * El sistema permite consultar un solo usuario
         *
         * @return
         */
        @GetMapping("/user/{cedula}")
        public Optional<Employee> obtenerEmployee(@PathVariable("cedula") Long cedula){

         return this.employeeService.buscarEmployee(cedula);
        }


        /**
         * El sistema permite editar un usuario
         *
         */
        @PatchMapping("/user/{cedula}")
        public boolean actualizarEmployee(@RequestBody Employee employee, @PathVariable("cedula") Long cedula){

        return this.employeeService.editarEmployee(employee, cedula);

        }

        /**
         * El sistema permite eliminar un usuario
         *
         * @return
         */
        @DeleteMapping("/user/{cedula}")
        public boolean eliminarEmployee(@PathVariable("cedula") Long cedula){

         return this.employeeService.eliminarEmployee(cedula);
        }
}
