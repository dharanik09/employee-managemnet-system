package com.employeestorageservice.employeestorageservice.mapper;

import com.employeestorageservice.employeestorageservice.dto.request.EmployeeRequest;
import com.employeestorageservice.employeestorageservice.entity.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeRequestMapper extends BaseMapper<Employee, EmployeeRequest>{
    @Override
    public Employee convertToEntity(EmployeeRequest dto, Object... args) {
        Employee employee = new Employee();
        if (dto != null) {
            BeanUtils.copyProperties(dto, employee);
        }
        return employee;
    }
    @Override
    public EmployeeRequest convertToDto(Employee entity, Object... args) {
        EmployeeRequest employeeRequest=new EmployeeRequest();
        if (entity != null) {
            BeanUtils.copyProperties(entity, employeeRequest);
        }
        return employeeRequest;    }
}
