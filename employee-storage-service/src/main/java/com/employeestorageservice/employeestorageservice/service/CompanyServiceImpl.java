package com.employeestorageservice.employeestorageservice.service;

import com.employeestorageservice.employeestorageservice.dto.request.CompanyRequest;
import com.employeestorageservice.employeestorageservice.dto.response.CompanyResponse;
import com.employeestorageservice.employeestorageservice.entity.Company;
import com.employeestorageservice.employeestorageservice.exception.EmployeeServiceBusinessException;
import com.employeestorageservice.employeestorageservice.mapper.CompanyRequestMapper;
import com.employeestorageservice.employeestorageservice.mapper.CompanyResponseMapper;
import com.employeestorageservice.employeestorageservice.repository.CompanyRepository;
import com.employeestorageservice.employeestorageservice.util.ValueMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@Data
@AllArgsConstructor
@Slf4j
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;
    private CompanyRequestMapper companyRequestMapper;
    private CompanyResponseMapper companyResponseMapper;
    @Override
    public List<CompanyResponse> createCompanyRecords(List<CompanyRequest> companyRequest) {
        log.info("Create Company Details");
        List<CompanyResponse> result = null;
        try {
            List<Company> company =  companyRequestMapper.convertToEntityList(companyRequest, new Company());
            result =  companyResponseMapper.convertToDtoList(companyRepository.saveAll(company), new CompanyResponse());
            log.debug("CompanyServiceImpl:createNewCompany received response from Database {}", ValueMapper.jsonAsString(result));
        }catch (Exception ex) {
            log.error("Exception occurred while persisting employee to database , Exception message {}", ex.getMessage());
            throw new EmployeeServiceBusinessException("Exception occurred while create a new company");
        }
        log.info("CompanyServiceImpl :createNewCompany execution ended.");
        return result;
    }
}
