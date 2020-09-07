package com.sda.jdbc;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class EmployeeRepository {

//    FIND ALL METHOD

public Set<Employee> findAll() throws SQLException {
    Set<Employee> employees = new HashSet<>();
    Connection conn = DriverManager.getConnection(
            DatabaseUtils.DATABASE_HOST,
            DatabaseUtils.DATABASE_USERNAME,
            DatabaseUtils.DATABASE_PASSWORD);

    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM employees");

    while(rs.next()) {

        Integer empId = rs.getInt("employeeId");
        String empName = rs.getString("firstName");

        Employee e = new Employee(empId, empName);
        employees.add(e);
    }

    rs.close();
    stmt.close();
    conn.close();

    return employees;
}

//3. Optional: Implement ProjectRepository and EmployeeRepository methods findAll, findById,
//deleteById, save, update

//    FIND BY ID METHOD
public Employee findById(Integer employeeId) throws SQLException {
    Employee employee = new Employee();
    Connection conn = DriverManager.getConnection(
            DatabaseUtils.DATABASE_HOST,
            DatabaseUtils.DATABASE_USERNAME,
            DatabaseUtils.DATABASE_PASSWORD);

    Statement stmt = conn.createStatement();

    ResultSet rs = stmt.executeQuery("SELECT * FROM employees WHERE employeeId = " + employeeId);

    while(rs.next()) {

        Integer empId = rs.getInt("employeeId");
        String empName = rs.getString("firstName");

        employee.setFirstName(empName);
        employee.setEmployeeId(empId);

    }
    rs.close();
    stmt.close();
    conn.close();
    return employee;
}
    }

