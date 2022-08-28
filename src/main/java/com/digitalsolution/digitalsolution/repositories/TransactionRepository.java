package com.digitalsolution.digitalsolution.repositories;

import com.digitalsolution.digitalsolution.entityes.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {


    @Query("FROM Transaction WHERE enterprise = :enterprise")
    List<Transaction> findByIdTransaction(@Param("enterprise") Long enterprise);
}
