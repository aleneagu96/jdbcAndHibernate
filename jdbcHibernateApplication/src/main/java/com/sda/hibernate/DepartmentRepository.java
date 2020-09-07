package com.sda.hibernate;

import com.sda.hibernate.Department;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.List;
import java.util.Set;


public class DepartmentRepository {
    public Department findById(Integer departmentId) {
        //Opening a way of communication with the database
        Session session = HibernateUtils.getSessionFactory().openSession();
        //Retrieving the department with the id 1
        Department dept = session.find(Department.class, departmentId);
        //Closing the communication with the database
        session.close();
        return dept;
    }
    public List<Department> findAll() {
        Session session = HibernateUtils.getSessionFactory().openSession();

        Query selectAllDeptsQuery = session.createQuery("from Department");

        List<Department> departments = selectAllDeptsQuery.list();

        session.close();
        return departments;
    }
    public List<Department> findByName(String departmentName) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Query selectDepartmentByNameQuery = session.createQuery("from Department d WHERE d.name = '" + departmentName + "'");
        List<Department> departments = selectDepartmentByNameQuery.list();
        session.close();
        return departments;
    }

    public void save(Department department) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction =session.beginTransaction();

        session.save(department);
        transaction.commit();
        session.close();
    }
    public void update(Department department) {
    }
    public void deleteById(Integer departmentId) {
    }
}
