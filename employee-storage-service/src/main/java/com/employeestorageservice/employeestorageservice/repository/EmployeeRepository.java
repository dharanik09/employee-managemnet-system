package com.employeestorageservice.employeestorageservice.repository;

import com.employeestorageservice.employeestorageservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
