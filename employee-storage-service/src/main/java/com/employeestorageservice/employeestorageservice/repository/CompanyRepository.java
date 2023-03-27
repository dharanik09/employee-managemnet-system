package com.employeestorageservice.employeestorageservice.repository;

import com.employeestorageservice.employeestorageservice.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
