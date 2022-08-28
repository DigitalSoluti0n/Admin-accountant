package com.digitalsolution.digitalsolution.repositories;

import com.digitalsolution.digitalsolution.entityes.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {

    /**
     * Método para consultar diferente al id
     * @param document
     * @return
     */
    @Query("FROM Enterprise WHERE document = :document")
    List<Enterprise> findByIdEnter(@Param("document") String document);


}
