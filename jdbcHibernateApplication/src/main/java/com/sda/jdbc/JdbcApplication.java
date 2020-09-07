package com.sda.jdbc;

import java.sql.*;
import java.util.Set;

public class JdbcApplication {
    public static void main(String[] args) throws SQLException {
//        DepartmentRepository dr = new DepartmentRepository();
//
//        Department id1 = dr.findById(1);
//        id1.setName("new name");
//
//        dr.update(id1);
//
      EmployeeRepository er = new EmployeeRepository();

      Employee id1 = er.findById(1);

        System.out.println(id1.getFirstName());







    }
}
