/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employeemanagement.service;

import com.employeemanagement.dto.CreateEmployeeDTO;
import com.employeemanagement.dto.EmployeeDetailsDTO;
import com.employeemanagement.entity.Address;
import com.employeemanagement.entity.Department;
import com.employeemanagement.entity.Employee;
import com.employeemanagement.exception.EmployeeNotFoundException;
import com.employeemanagement.repository.AddressRepository;
import com.employeemanagement.repository.DepartmentRepository;
import com.employeemanagement.repository.EmployeeRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nikhil
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    public List<EmployeeDetailsDTO> getAllEmployeeDetails() {
        logger.info("Fetching all employee details");
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(this::mapToEmployeeDetailsDTO)
                .collect(Collectors.toList());
    }

    private EmployeeDetailsDTO mapToEmployeeDetailsDTO(Employee employee) {
        EmployeeDetailsDTO dto = new EmployeeDetailsDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setGender(employee.getGender());
        dto.setContact(employee.getContact());
        dto.setAddress(employee.getAddress());
        dto.setDepartment(employee.getDepartment());
        return dto;
    }

    @Transactional
    public Employee createEmployee(CreateEmployeeDTO createEmployeeDTO) {
        logger.info("Createing employee");
        // Create an Address entity
        Address address = new Address();
        address.setStreet1(createEmployeeDTO.getStreet1());
        address.setStreet2(createEmployeeDTO.getStreet2());
        address.setCity(createEmployeeDTO.getCity());
        address.setState(createEmployeeDTO.getState());
        address = addressRepository.save(address);

        // Create a Department entity or fetch an existing one by name
        Department department = departmentRepository.findByDepartmentName(createEmployeeDTO.getDepartmentName());
        if (department == null) {
            department = new Department();
            department.setDepartmentName(createEmployeeDTO.getDepartmentName());
            department = departmentRepository.save(department);
        }

        // Create an Employee entity
        Employee employee = new Employee();
        employee.setName(createEmployeeDTO.getName());
        employee.setGender(createEmployeeDTO.getGender());
        employee.setContact(createEmployeeDTO.getContact());
        employee.setAddress(address);
        employee.setDepartment(department);

        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployeesByDepartment(String departmentName) {
        logger.info("Fetching employee by department");
        List<Employee> employees = employeeRepository.findByDepartmentDepartmentName(departmentName);

        if (employees.isEmpty()) {
            logger.warn("No employees found in department: {}", departmentName);
            throw new EmployeeNotFoundException("No employees found in department: " + departmentName);
        }
        return employees;
    }
}
