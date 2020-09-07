package com.sda.jdbc;

import java.util.Date;
import java.util.Set;

public class Employee {
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String email;
    private Integer salary;
    private DepartmentJdbc departmentJdbc;
    private Set<Employee> employees;

    public Employee(Integer empId, String empName) {

    }

    public Employee() {

    }


    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public DepartmentJdbc getDepartmentJdbc() {
        return departmentJdbc;
    }

    public void setDepartmentJdbc(DepartmentJdbc departmentJdbc) {
        this.departmentJdbc = departmentJdbc;
    }


}

