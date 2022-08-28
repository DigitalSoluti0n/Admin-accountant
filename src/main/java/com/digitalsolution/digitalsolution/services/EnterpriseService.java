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
    public boolean actualizarEnterprise(Enterprise enterprise, Long id){
        Optional<Enterprise> enterpriseBuscar =     this.enterpriseRepository.findById(id);//buscar

        if (enterpriseBuscar.isPresent()){
            enterpriseBuscar.get().setName(enterprise.getName());
            enterpriseBuscar.get().setDocument(enterprise.getDocument());
            enterpriseBuscar.get().setPhone(enterprise.getPhone());
            enterpriseBuscar.get().setAddress(enterprise.getAddress());
            enterpriseBuscar.get().setUsers(enterprise.getUsers());
            enterpriseBuscar.get().setTransactions(enterprise.getTransactions());
            enterpriseBuscar.get().setCreatedat(enterprise.getCreatedat());
            enterpriseBuscar.get().setUpdatedat(enterprise.getUpdatedat());

            this.enterpriseRepository.save(enterpriseBuscar.get());
            return  true;
        }

        return false;
    }

    /**
     * El sistema permite eliminar una empresa
     */
    public boolean eliminarEnterprise(Long id){
        this.enterpriseRepository.deleteById(id);

        return true;
    }

    /**
     * El sistema permite consultar una sola empresa
     */
    public Optional<Enterprise> obtenerUnaEnterprise(Long id){

        return this.enterpriseRepository.findById(id);
    }


}
