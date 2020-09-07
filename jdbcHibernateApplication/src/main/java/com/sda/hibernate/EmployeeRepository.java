package com.sda.hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Set;
public class EmployeeRepository {
    public Employee findById(Integer employeeId) {
        //Opening a way of communication with the database
        Session session = HibernateUtils.getSessionFactory().openSession();
        //Retrieving the employee with the id 1
        Employee dept = session.find(Employee.class, employeeId);
        //Closing the communication with the database
        session.close();
        return dept;
    }
    public Set<Employee> findAll() {
        return null;
    }
    public Employee findByName(String employeeName) {
        return null;
    }
    public void save(Employee employee) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
    }

    public List<Employee> findByDepartmentName(String departmentName) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Query selectEmployeeByDepartment = session.createQuery("from Employee e WHERE e.department.name = '" + departmentName + "'");
        List<Employee> employees = selectEmployeeByDepartment.list();
        session.close();
        return employees;
    }



    public void update(Employee employee) {
    }
    public void deleteById(Integer employeeId) {
    }
}