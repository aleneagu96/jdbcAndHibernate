package com.sda.hibernate;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
// POJO - Plain Old Java Object
// Classes that have private properties, public getters/setters, constructors
// !!! Hibernate annotations
@Entity
@Table(name = "departments")  // optional if table name is the same

public class Department {
    @Id  // marks the property as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // marks the primary key as AUTO INCREMENTED
    private Integer departmentId;

    @Column(name = "name")  // optional if column name is the same
    private String name;

    @OneToMany(mappedBy = "department")
    private Set<Employee> employees = new HashSet<>();

    public Department() {
    }
    public Department(Integer departmentId, String name) {
        this.departmentId = departmentId;
        this.name = name;
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
    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", name='" + name + '\'' +
                '}';
    }
}