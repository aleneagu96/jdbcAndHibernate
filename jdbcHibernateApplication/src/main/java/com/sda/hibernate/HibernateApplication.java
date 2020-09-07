package com.sda.hibernate;

import org.hibernate.Session;

import java.util.List;

public class HibernateApplication {
  public static void main(String[] arguments) {

//      DepartmentRepository dr = new DepartmentRepository();
//        System.out.println(dr.findById(1));
//
//        Department hibernateDept = new Department();
//        hibernateDept.setName("My new hib dept");
//        dr.save(hibernateDept);
//
//
//        ProjectRepository pr = new ProjectRepository();
//        System.out.println(pr.findById(2));
//
//        Project hibernateProj = new Project();
//        hibernateProj.setDescription("This is a new project");
//        pr.save(hibernateProj);
//        hibernateProj.setDescription("lala");
//        pr.update(hibernateProj);
//
//        EmployeeRepository er = new EmployeeRepository();
//        System.out.println(er.findById(3));
//
//        Employee hibernateEmp = new Employee();
//        hibernateEmp.setFirstName("John");
//        hibernateEmp.setLastName("Johanson");
//        hibernateEmp.setEmail("johnj@gmail.com");
//        hibernateEmp.setSalary(2900);
//        er.save(hibernateEmp);

      EmployeeRepository employeeRepository = new EmployeeRepository();
//      System.out.println(employeeRepository.findById(3));

    DepartmentRepository departmentRepository = new DepartmentRepository();
    List<Department> departmentList = departmentRepository.findAll();
    for (Department d : departmentList) {
      System.out.println(d);
    }


    List<Department> deparmentByName = departmentRepository.findByName("Dev");
    for (Department d : deparmentByName) {
      System.out.println(d);

    }
    List<Employee> employees = employeeRepository.findByDepartmentName("Finance");
    for(Employee e : employees) {
      System.out.println(e);
    }
  }
}