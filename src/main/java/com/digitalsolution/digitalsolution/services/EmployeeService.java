package com.digitalsolution.digitalsolution.services;

import com.digitalsolution.digitalsolution.entityes.Employee;
import com.digitalsolution.digitalsolution.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * El sistema permite consultar todos los usuarios
     *
     * @return
     */
    public List<Employee> listEmployee(){

        return this.employeeRepository.findAll();

    }

    /**
     * El sistema permite consultar un solo usuario
     *
     * @return
     */
    public Optional<Employee> buscarEmployee(long cedula){

        return this.employeeRepository.findById(cedula);
    }

    /**
     * El sistema permite crear un usuario
     *
     * @return
     */
    public boolean crearEmployee(Employee employee){

        if (!this.employeeRepository.findById(employee.getCedula()).isPresent()){
            this.employeeRepository.save(employee);
            return true;
        }

        return false;
    }

    /**
     * El sistema permite editar un usuario
     *
     * @return
     */
    public boolean editarEmployee(Employee employee, long cedula){

        Optional<Employee> datEmployee = this.employeeRepository.findById(cedula);

            if (datEmployee.isPresent()){

                datEmployee.get().setName(employee.getName());
                datEmployee.get().setEmail(employee.getEmail());
                datEmployee.get().setProfile(employee.getProfile());
                datEmployee.get().setRole(employee.getRole());
                datEmployee.get().setEnterprise(employee.getEnterprise());
                datEmployee.get().setTransactions(employee.getTransactions());
                datEmployee.get().setUpdatedat(employee.getUpdatedat());
                datEmployee.get().setCreatedat(employee.getCreatedat());

                this.employeeRepository.save(datEmployee.get());
                return true;
            }



        return false;
    }

    /**
     * El sistema permite eliminar un usuario
     *
     */
    public boolean eliminarEmployee(long cedula){

            if (this.employeeRepository.findById(cedula).isPresent()){
                this.employeeRepository.deleteById(cedula);
                return true;
            }

        return false;
    }
}
