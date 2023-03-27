package com.employeestorageservice.employeestorageservice.mapper;

import com.employeestorageservice.employeestorageservice.dto.response.CompanyResponse;
import com.employeestorageservice.employeestorageservice.dto.response.EmployeeResponse;
import com.employeestorageservice.employeestorageservice.entity.Company;
import com.employeestorageservice.employeestorageservice.entity.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompanyResponseMapper extends BaseMapper<Company, CompanyResponse>{
    @Override
    public Company convertToEntity(CompanyResponse dto, Object... args) {
        Company company = new Company();
        if (dto != null) {
            BeanUtils.copyProperties(dto, company);
        }
        return company;
    }
    @Override
    public CompanyResponse convertToDto(Company entity, Object... args) {
        CompanyResponse companyResponse=new CompanyResponse();
        if (entity != null) {
            BeanUtils.copyProperties(entity, companyResponse);
        }
        return companyResponse;
    }
}
