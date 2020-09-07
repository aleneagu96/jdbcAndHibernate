package com.sda.jdbc;

import java.util.Set;

// POJO -plain old java objects
//classes that have private fields, public getters and setters, and constructor
public class DepartmentJdbc {
    private Integer departmentId;
    private String name;
    private Set<Employee> employees;

    public DepartmentJdbc(Integer departmentId, String name) {
        this.departmentId = departmentId;
        this.name = name;
    }

    public DepartmentJdbc() {

    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
