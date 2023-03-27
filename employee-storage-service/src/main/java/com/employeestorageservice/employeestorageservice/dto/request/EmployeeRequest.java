package com.employeestorageservice.employeestorageservice.dto.request;

import com.employeestorageservice.employeestorageservice.entity.Company;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {
    private int id;
    @NotBlank(message = "Employee Name should not be NULL or EMPTY")
    private String name;
    @NotBlank(message = "Employee Email should not be NULL or EMPTY")
    private String email;
    @NotBlank(message = "Employee Address should not be NULL or EMPTY")
    private String address;
    @NotNull(message = "Employee Salary should not be NULL or EMPTY")
    private double salary;
    private Company company;

}
