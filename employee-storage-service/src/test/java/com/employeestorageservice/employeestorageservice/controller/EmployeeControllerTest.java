package com.employeestorageservice.employeestorageservice.controller;

import com.employeestorageservice.employeestorageservice.dto.request.EmployeeRequest;
import com.employeestorageservice.employeestorageservice.dto.response.EmployeeResponse;
import com.employeestorageservice.employeestorageservice.entity.Company;
import com.employeestorageservice.employeestorageservice.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService mockEmployeeService;

    static final String BASE_URL = "http://localhost:8081/api/v1";

    @Test
    void testCreateEmployeeRecords() throws Exception {
        // Setup
        // Configure EmployeeService.createEmployeeRecords(...).
        final EmployeeResponse employeeResponse = new EmployeeResponse(0, "name", "email", "address", 0.0,
                new Company(0, "name"));
        when(mockEmployeeService.createEmployeeRecords(
                new EmployeeRequest(0, "name", "email", "address", 0.0, new Company(0, "name"))))
                .thenReturn(employeeResponse);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get(BASE_URL + "/employee")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testViewEmployeeDetails() throws Exception {
        // Setup
        // Configure EmployeeService.viewEmployeeDetails(...).
        final List<EmployeeResponse> employeeResponses = List.of(
                new EmployeeResponse(0, "name", "email", "address", 0.0, new Company(0, "name")));
        when(mockEmployeeService.viewEmployeeDetails()).thenReturn(employeeResponses);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get(BASE_URL + "/employee")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testViewEmployeeDetails_EmployeeServiceReturnsNoItems() throws Exception {
        // Setup
        when(mockEmployeeService.viewEmployeeDetails()).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get(BASE_URL + "/employee")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testUpdateEmployeeDetails() throws Exception {
        // Setup
        // Configure EmployeeService.updateEmployeeDetails(...).
        final EmployeeResponse employeeResponse = new EmployeeResponse(0, "name", "email", "address", 0.0,
                new Company(0, "name"));
        when(mockEmployeeService.updateEmployeeDetails(0,
                new EmployeeRequest(0, "name", "email", "address", 0.0, new Company(0, "name"))))
                .thenReturn(employeeResponse);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(put(BASE_URL + "/employee/updateEmployeeDetails/{id}", 0)
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testDeleteEmployeeDetailsByID() throws Exception {
        // Setup
        when(mockEmployeeService.deleteEmployeeDetailsByID(0)).thenReturn(false);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(delete(BASE_URL + "/employee/{id}", 0)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testGetAvgSalaryOfEmployee() throws Exception {
        // Setup
        when(mockEmployeeService.getAvgSalaryOfEmployee()).thenReturn(Map.ofEntries(Map.entry("value", 0.0)));

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get(BASE_URL + "/employee/listavgsalaryofemployee")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }
}
