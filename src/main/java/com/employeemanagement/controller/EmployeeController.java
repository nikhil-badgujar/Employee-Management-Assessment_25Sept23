/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employeemanagement.controller;

import com.employeemanagement.dto.CreateEmployeeDTO;
import com.employeemanagement.dto.EmployeeDetailsDTO;
import com.employeemanagement.entity.Employee;
import com.employeemanagement.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nikhil
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/details")
    public List<EmployeeDetailsDTO> getAllEmployeeDetails() {
        return employeeService.getAllEmployeeDetails();
    }

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody CreateEmployeeDTO createEmployeeDTO) {
        return employeeService.createEmployee(createEmployeeDTO);
    }

    @GetMapping("/byDepartment")
    public List<Employee> getEmployeesByDepartment(@RequestParam String departmentName) {
        return employeeService.getEmployeesByDepartment(departmentName);
    }
}
