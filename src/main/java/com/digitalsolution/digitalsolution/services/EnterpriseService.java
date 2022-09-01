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
    public boolean crearEnterprise(Enterprise enterprise){

        if (!this.enterpriseRepository.findById(enterprise.getNit()).isPresent()){
            this.enterpriseRepository.save(enterprise);
            return true;
        }

        return false;
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
        if (this.enterpriseRepository.findById(id).isPresent()){
            this.enterpriseRepository.deleteById(id);
            return true;
        }


        return false;
    }

    /**
     * El sistema permite consultar una sola empresa
     */
    public Optional<Enterprise> obtenerUnaEnterprise(Long id){



        return this.enterpriseRepository.findById(id);
    }

    //Método de prueba para consultar a determinada columna

    /**
     * El sistema permite consultar una sola empresa por documento
     */
    public List<Enterprise> obtenerEnterpriseDocument(String documet){

        /*
        List<String> datos = new ArrayList<>();

        datos.add(enterpriseRepository.findByIdEnter(documet).get(0).getName());
        return datos;
        */
        return this.enterpriseRepository.findByIdEnter(documet);
    }



}
