package com.digitalsolution.digitalsolution.services;


import com.digitalsolution.digitalsolution.entityes.Enterprise;
import com.digitalsolution.digitalsolution.repositories.EnterpriseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnterpriseService {

    private EnterpriseRepository enterpriseRepository;

    public EnterpriseService(EnterpriseRepository repository){
        this.enterpriseRepository = repository;
    }

    /**
     * El sistema permite consultar todas las empresas
     */
    public List<Enterprise> obtenerEnterprise(){
        return this.enterpriseRepository.findAll();
    }

    /**
     * El sistema permite crear una empresa
     */
    public Enterprise crearEnterprise(Enterprise enterprise){
        return this.enterpriseRepository.save(enterprise);
    }

    /**
     * El sistema permite editar una empresa
     */
    public boolean actualizarEnterprise(Long nit){
        Optional<Enterprise> enterprise =     this.enterpriseRepository.findById(nit);//buscar

        if (enterprise.isPresent()){
            enterprise.get().setName("prueba de actualizar");
            this.enterpriseRepository.save(enterprise.get());
            return  true;
        }

        return false;
    }


}
