package com.employeestorageservice.employeestorageservice.service;


import com.employeestorageservice.employeestorageservice.dto.request.CompanyRequest;
import com.employeestorageservice.employeestorageservice.dto.response.CompanyResponse;

import java.util.Collection;
import java.util.List;

public interface CompanyService {
    List<CompanyResponse> createCompanyRecords(List<CompanyRequest> companyRequest);
}
