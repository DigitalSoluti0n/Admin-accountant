package com.digitalsolution.digitalsolution.repositories;

import com.digitalsolution.digitalsolution.entityes.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {
}
