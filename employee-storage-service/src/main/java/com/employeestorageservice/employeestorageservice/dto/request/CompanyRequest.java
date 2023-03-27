package com.employeestorageservice.employeestorageservice.dto.request;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRequest {
    private int id;
    @NotBlank(message = "Company Name should not be NULL or EMPTY")
    private String name;
}
