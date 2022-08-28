package com.digitalsolution.digitalsolution.services;


import com.digitalsolution.digitalsolution.entityes.Enterprise;
import com.digitalsolution.digitalsolution.repositories.EnterpriseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
