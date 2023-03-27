package com.employeestorageservice.employeestorageservice.service;

import com.employeestorageservice.employeestorageservice.dto.request.EmployeeRequest;
import com.employeestorageservice.employeestorageservice.dto.response.EmployeeResponse;
import com.employeestorageservice.employeestorageservice.entity.Company;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    EmployeeResponse createEmployeeRecords(EmployeeRequest employeeRequest);

    List<EmployeeResponse> viewEmployeeDetails();

    EmployeeResponse updateEmployeeDetails(int id, EmployeeRequest employeeRequest);

    boolean deleteEmployeeDetailsByID(int id);

    Map<String, Double> getAvgSalaryOfEmployee();
}
