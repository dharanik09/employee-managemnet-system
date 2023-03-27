package com.employeestorageservice.employeestorageservice.controller;

import com.employeestorageservice.employeestorageservice.dto.request.CompanyRequest;
import com.employeestorageservice.employeestorageservice.dto.request.EmployeeRequest;
import com.employeestorageservice.employeestorageservice.dto.response.APIResponse;
import com.employeestorageservice.employeestorageservice.dto.response.CompanyResponse;
import com.employeestorageservice.employeestorageservice.dto.response.EmployeeResponse;
import com.employeestorageservice.employeestorageservice.service.CompanyService;
import com.employeestorageservice.employeestorageservice.service.EmployeeService;
import com.employeestorageservice.employeestorageservice.util.ValueMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("api/v1/company")
@AllArgsConstructor
@Slf4j
public class CompanyController {
    private CompanyService companyService;
    public static final String SUCCESS = "Success";

    @PostMapping
    public ResponseEntity<APIResponse> createCompanyRecords(@Valid @RequestBody List<CompanyRequest> companyRequest){
        log.info("CompanyController::create new company records request body {}", ValueMapper.jsonAsString(companyRequest));
        List<CompanyResponse> companyResponse = companyService.createCompanyRecords(companyRequest);
        APIResponse<CompanyResponse> responseDTO = APIResponse
                .<CompanyResponse>builder()
                .status(SUCCESS)
                .results(companyResponse)
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);

    }

}
