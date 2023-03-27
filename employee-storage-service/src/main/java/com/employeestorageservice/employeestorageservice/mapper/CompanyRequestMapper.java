package com.employeestorageservice.employeestorageservice.mapper;

import com.employeestorageservice.employeestorageservice.dto.request.CompanyRequest;
import com.employeestorageservice.employeestorageservice.dto.request.EmployeeRequest;
import com.employeestorageservice.employeestorageservice.entity.Company;
import com.employeestorageservice.employeestorageservice.entity.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompanyRequestMapper extends BaseMapper<Company, CompanyRequest>{
    @Override
    public Company convertToEntity(CompanyRequest dto, Object... args) {
        Company company = new Company();
        if (dto != null) {
            BeanUtils.copyProperties(dto, company);
        }
        return company;
    }
    @Override
    public CompanyRequest convertToDto(Company entity, Object... args) {
        CompanyRequest companyRequest=new CompanyRequest();
        if (entity != null) {
            BeanUtils.copyProperties(entity, companyRequest);
        }
        return companyRequest;
    }
}
