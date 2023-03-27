package com.employeestorageservice.employeestorageservice.dto.response;

import com.employeestorageservice.employeestorageservice.entity.Company;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponse {
    private int id;
    private String name;
    private String email;
    private String address;
    private double salary;
    private Company company;
}
