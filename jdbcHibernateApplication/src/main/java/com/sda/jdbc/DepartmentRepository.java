package com.sda.jdbc;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class DepartmentRepository {
//     findAll - returns all rows
//     findById - returns the row with the corresponding id
//     save - saves a new entry in the table
//     delete - deletes an entry from the table by its id
//     update - updates an existing entry from the table by its id
//
//    UPDATE METHOD
    public void update(DepartmentJdbc departmentJdbc) throws SQLException {
        Connection conn = DriverManager.getConnection(
                DatabaseUtils.DATABASE_HOST,
                DatabaseUtils.DATABASE_USERNAME,
                DatabaseUtils.DATABASE_PASSWORD);
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("UPDATE departments  SET name = '"+ departmentJdbc.getName() + "' " +
                "WHERE departmentId =" + departmentJdbc.getDepartmentId());
        stmt.close();
        conn.close();
    }

//    SAVE METHOD
    public void save(DepartmentJdbc departmentJdbc) throws SQLException {
        // The connection object opens a tunnel to the database
        // Through which we will execute SQL queries
        Connection conn = DriverManager.getConnection(
                DatabaseUtils.DATABASE_HOST,
                DatabaseUtils.DATABASE_USERNAME,
                DatabaseUtils.DATABASE_PASSWORD);
        // The createStatement() allows us the initialize a SQL query
        // Which we will then be able to run
        Statement stmt = conn.createStatement();
        // Instead of executeQuery use executeUpdate for INSERT/UPDATE/DELETE
        stmt.executeUpdate("INSERT INTO departments (name) VALUES ('" + departmentJdbc.getName() + "')");
        stmt.close();
        conn.close();
    }


//    FIND ALL METHOD
    public Set<DepartmentJdbc> findAll() throws SQLException {
        // Initializing the empty set that will be populated with the results from the database
        Set<DepartmentJdbc> departmentJdbcs = new HashSet<>();
        // The connection object opens a tunnel to the database
        // Through which we will execute SQL queries
        Connection conn = DriverManager.getConnection(
                DatabaseUtils.DATABASE_HOST,
                DatabaseUtils.DATABASE_USERNAME,
                DatabaseUtils.DATABASE_PASSWORD);
        // The createStatement() allows us the initialize a SQL query
        // Which we will then be able to run
        Statement stmt = conn.createStatement();
        // The executeQuery() method allows us to execute a SQL query
        ResultSet rs = stmt.executeQuery("SELECT * FROM departments");
        // Iterate all rows from the result
        while(rs.next()) {
            // Extract the data from the particular columns
            Integer deptId = rs.getInt("departmentId");
            String deptName = rs.getString("name");
            // Initializing a department with the data from the returned row
            // And adding it to the set
            DepartmentJdbc d = new DepartmentJdbc(deptId, deptName);
            departmentJdbcs.add(d);
        }
        // Closing the database objects
        rs.close();
        stmt.close();
        conn.close();
        // Returning the set with all the departments from the database
        return departmentJdbcs;
    }

//    FIND BY ID METHOD
    public DepartmentJdbc findById(Integer departmentId) throws SQLException {
        DepartmentJdbc departmentJdbc = new DepartmentJdbc();
        // The connection object opens a tunnel to the database
        // Through which we will execute SQL queries
        Connection conn = DriverManager.getConnection(
                DatabaseUtils.DATABASE_HOST,
                DatabaseUtils.DATABASE_USERNAME,
                DatabaseUtils.DATABASE_PASSWORD);
        // The createStatement() allows us the initialize a SQL query
        // Which we will then be able to run
        Statement stmt = conn.createStatement();
        // The executeQuery() method allows us to execute a SQL query
        ResultSet rs = stmt.executeQuery("SELECT * FROM departments WHERE departmentId = " + departmentId);

        // Iterate all rows from the result
        while(rs.next()) {
            // Extract the data from the particular columns
            Integer deptId = rs.getInt("departmentId");
            String deptName = rs.getString("name");

            departmentJdbc.setDepartmentId(deptId);
            departmentJdbc.setName(deptName);
        }
        rs.close();
        stmt.close();
        conn.close();
        return departmentJdbc;
    }

}


