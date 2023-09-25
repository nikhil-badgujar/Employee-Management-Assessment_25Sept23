/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employeemanagement.dto;

import com.employeemanagement.entity.Address;
import com.employeemanagement.entity.Department;

/**
 *
 * @author nikhil
 */
public class EmployeeDetailsDTO {

    private Long id;
    private String name;
    private String gender;
    private String contact;
    private Address address;
    private Department department;

    // Constructors, getters, and setters
    public EmployeeDetailsDTO() {
    }

    public EmployeeDetailsDTO(Long id, String name, String gender, String contact, Address address, Department department) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.contact = contact;
        this.address = address;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "EmployeeDetailsDTO{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", contact=" + contact + ", address=" + address + ", department=" + department + '}';
    }

}
