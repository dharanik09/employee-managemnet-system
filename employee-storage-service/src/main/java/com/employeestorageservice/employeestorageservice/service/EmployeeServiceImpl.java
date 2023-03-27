package com.employeestorageservice.employeestorageservice.service;

import com.employeestorageservice.employeestorageservice.dto.request.EmployeeRequest;
import com.employeestorageservice.employeestorageservice.dto.response.EmployeeResponse;
import com.employeestorageservice.employeestorageservice.entity.Company;
import com.employeestorageservice.employeestorageservice.entity.Employee;
import com.employeestorageservice.employeestorageservice.exception.EmployeeServiceBusinessException;
import com.employeestorageservice.employeestorageservice.mapper.EmployeeRequestMapper;
import com.employeestorageservice.employeestorageservice.mapper.EmployeeResponseMapper;
import com.employeestorageservice.employeestorageservice.repository.EmployeeRepository;
import com.employeestorageservice.employeestorageservice.util.ValueMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Data
@AllArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private EmployeeRequestMapper employeeRequestMapper;
    private EmployeeResponseMapper employeeResponseMapper;
    @Override
    public EmployeeResponse createEmployeeRecords(EmployeeRequest employeeRequest) {
        log.info("Create Employee Details");
        EmployeeResponse result = null;
        try {
            Employee employee =  employeeRequestMapper.convertToEntity(employeeRequest, new Employee());
            result =  employeeResponseMapper.convertToDto(employeeRepository.save(employee), new EmployeeResponse());
            log.debug("EmployeeService:createNewEmployee received response from Database {}", ValueMapper.jsonAsString(result));
        }catch (Exception ex) {
            log.error("Exception occurred while persisting employee to database , Exception message {}", ex.getMessage());
            throw new EmployeeServiceBusinessException("Exception occurred while create a new employee");
        }
        log.info("EmployeeService :createNewEmployee execution ended.");
        return result;
    }

    @Override
    public List<EmployeeResponse> viewEmployeeDetails() {
        log.info("Create Employee Details");
        List<EmployeeResponse> result = null;
        try {
            result =  employeeResponseMapper.convertToDtoList(employeeRepository.findAll(), new EmployeeResponse());
            log.debug("EmployeeService:createNewEmployee received response from Database {}", ValueMapper.jsonAsString(result));
        }catch (Exception ex) {
            log.error("Exception occurred while persisting employee to database , Exception message {}", ex.getMessage());
            throw new EmployeeServiceBusinessException("Exception occurred while create a new employee");
        }
        log.info("EmployeeService :createNewEmployee execution ended.");
        return result;
    }

    @Override
    public EmployeeResponse updateEmployeeDetails(int id, EmployeeRequest employeeRequest) {
        log.info("Create Employee Details");
        EmployeeResponse result = null;
        try {
            if(!employeeRepository.existsById(id)) new EmployeeServiceBusinessException("Employee not found for this id :: " + id);
            Employee employee =  employeeRequestMapper.convertToEntity(employeeRequest, new Employee());
            result =  employeeResponseMapper.convertToDto(employeeRepository.save(employee), new EmployeeResponse());
            log.debug("EmployeeService:createNewEmployee received response from Database {}", ValueMapper.jsonAsString(result));
        }catch (Exception ex) {
            log.error("Exception occurred while persisting employee to database , Exception message {}", ex.getMessage());
            throw new EmployeeServiceBusinessException("Exception occurred while create a new employee");
        }
        log.info("EmployeeService :createNewEmployee execution ended.");
        return result;
    }

    @Override
    public boolean deleteEmployeeDetailsByID(int id) {
        log.info("Create Employee Details");
        EmployeeResponse result = null;
        try {
            boolean isExists = employeeRepository.existsById(id);
            if(!isExists) throw new EmployeeServiceBusinessException("Employee not found for this id :: " + id);
            employeeRepository.deleteById(id);
        }catch (Exception ex) {
            log.error("Exception occurred while persisting employee to database , Exception message {}", ex.getMessage());
            throw new EmployeeServiceBusinessException("Exception occurred while create a new employee");
        }
        log.info("EmployeeService :createNewEmployee execution ended.");
        return true;
    }

    @Override
    public Map<String, Double> getAvgSalaryOfEmployee() {
        log.info("Create Employee Details");
        List<Employee> result = null;
        Map<String, Double> results = null;
        try {
            result =  employeeRepository.findAll();
            //select b.name, AVG(a.salary) as salary from employee a, company b where a.company_id = b.id GROUP BY b.name
            results = result.stream().collect(Collectors.groupingBy(s -> s.getCompany().getName(), Collectors.averagingDouble(Employee::getSalary)));
            log.debug("EmployeeService:createNewEmployee received response from Database {}", ValueMapper.jsonAsString(result));
        }catch (Exception ex) {
            log.error("Exception occurred while persisting employee to database , Exception message {}", ex.getMessage());
            throw new EmployeeServiceBusinessException("Exception occurred while create a new employee");
        }
        log.info("EmployeeService :createNewEmployee execution ended.");
        return results;
    }
}
