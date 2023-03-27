package com.employeestorageservice.employeestorageservice.mapper;

import com.employeestorageservice.employeestorageservice.dto.request.EmployeeRequest;
import com.employeestorageservice.employeestorageservice.dto.response.EmployeeResponse;
import com.employeestorageservice.employeestorageservice.entity.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeResponseMapper extends BaseMapper<Employee, EmployeeResponse>{
    @Override
    public Employee convertToEntity(EmployeeResponse dto, Object... args) {
        Employee employee = new Employee();
        if (dto != null) {
            BeanUtils.copyProperties(dto, employee);
        }
        return employee;
    }
    @Override
    public EmployeeResponse convertToDto(Employee entity, Object... args) {
        EmployeeResponse employeeResponse=new EmployeeResponse();
        if (entity != null) {
            BeanUtils.copyProperties(entity, employeeResponse);
        }
        return employeeResponse;
    }
}
