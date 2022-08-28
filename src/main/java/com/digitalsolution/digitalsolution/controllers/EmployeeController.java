package com.digitalsolution.digitalsolution.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

        @GetMapping("/users")
        public void obtenerEmployee(){

        }
        @PostMapping("/users")
        public void agregarEmployeePost(){

        }

        @GetMapping("/user/{id}")
        public void obtenerEmployee(@PathVariable("id") Long id){

        }

        @PatchMapping("/user/{id}")
        public void actualizarEmployee(@PathVariable("id") Long id){

        }

        @DeleteMapping("/user/{id}")
        public void eliminarEmployee(@PathVariable("id") Long id){

        }
}
