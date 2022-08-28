package com.digitalsolution.digitalsolution.repositories;

import com.digitalsolution.digitalsolution.entityes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
