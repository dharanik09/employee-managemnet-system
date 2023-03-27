package com.employeestorageservice.employeestorageservice.controller;

import com.employeestorageservice.employeestorageservice.dto.request.EmployeeRequest;
import com.employeestorageservice.employeestorageservice.dto.response.APIResponse;
import com.employeestorageservice.employeestorageservice.dto.response.EmployeeResponse;
import com.employeestorageservice.employeestorageservice.entity.Company;
import com.employeestorageservice.employeestorageservice.entity.Employee;
import com.employeestorageservice.employeestorageservice.service.EmployeeService;
import com.employeestorageservice.employeestorageservice.util.ValueMapper;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.invoker.UrlArgumentResolver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/employee")
@AllArgsConstructor
@Slf4j
public class EmployeeController {
    private EmployeeService employeeService;
    public static final String SUCCESS = "Success";

    @RequestMapping(params = "")
    public ResponseEntity<APIResponse> createEmployeeRecords(@Valid @RequestBody EmployeeRequest employeeRequest){
        log.info("EmployeeController::create new employee records request body {}", ValueMapper.jsonAsString(employeeRequest));
        EmployeeResponse employeeResponse = employeeService.createEmployeeRecords(employeeRequest);
        APIResponse<EmployeeResponse> responseDTO = APIResponse
                .<EmployeeResponse>builder()
                .status(SUCCESS)
                .result(employeeResponse)
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);

    }
    @GetMapping
    public ResponseEntity<APIResponse> viewEmployeeDetails(){
        List<EmployeeResponse> employeeResponse = employeeService.viewEmployeeDetails();
        APIResponse<EmployeeResponse> responseDTO = APIResponse
                .<EmployeeResponse>builder()
                .status(SUCCESS)
                .results(employeeResponse)
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }
    @PutMapping("updateEmployeeDetails/{id}")
    public ResponseEntity<APIResponse> updateEmployeeDetails(@Valid @PathVariable(value = "id") @NotBlank(message = "ID Should not be Null or Blank") int id,
                                                             @RequestBody EmployeeRequest employeeRequest){
        log.info("EmployeeController::create new employee records request body {}", ValueMapper.jsonAsString(employeeRequest));
        EmployeeResponse employeeResponse = employeeService.updateEmployeeDetails(id, employeeRequest);
        APIResponse<EmployeeResponse> responseDTO = APIResponse
                .<EmployeeResponse>builder()
                .status(SUCCESS)
                .result(employeeResponse)
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map> deleteEmployeeDetailsByID(@Valid @PathVariable(value = "id")  @NotBlank(message = "ID Should not be Null or Blank") int id
                                                           ){
        boolean employeeResponse = employeeService.deleteEmployeeDetailsByID(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", employeeResponse);
        return new ResponseEntity<Map>(response, HttpStatus.OK);

    }
    @GetMapping("/listavgsalaryofemployee")
    public ResponseEntity<Map> getAvgSalaryOfEmployee(){
        Map<String, Double> employeeResponse = employeeService.getAvgSalaryOfEmployee();
        return new ResponseEntity<Map>(employeeResponse, HttpStatus.OK);
    }
}
