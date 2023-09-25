/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employeemanagement.dto;

/**
 *
 * @author nikhil
 */
public class CreateEmployeeDTO {

    private String name;
    private String gender;
    private String contact;
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String departmentName;

    // Constructors, getters, and setters
    public CreateEmployeeDTO() {
    }

    public CreateEmployeeDTO(String name, String gender, String contact, String street1, String street2, String city, String state, String departmentName) {
        this.name = name;
        this.gender = gender;
        this.contact = contact;
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.departmentName = departmentName;
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

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "CreateEmployeeDTO{" + "name=" + name + ", gender=" + gender + ", contact=" + contact + ", street1=" + street1 + ", street2=" + street2 + ", city=" + city + ", state=" + state + ", departmentName=" + departmentName + '}';
    }

}
