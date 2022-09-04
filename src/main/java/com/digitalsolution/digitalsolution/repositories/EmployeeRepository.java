package com.digitalsolution.digitalsolution.repositories;

import com.digitalsolution.digitalsolution.entityes.Employee;
import com.digitalsolution.digitalsolution.entityes.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {



    @Query("FROM Employee WHERE cedula = :cedula")
    List<Transaction> findByIdTransaction(@Param("cedula") Long cedula);

}
