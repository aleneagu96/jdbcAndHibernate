package com.sda.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProjectRepository {
    public Project findById(Integer projectId) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Project proj = session.find(Project.class, projectId);
        session.close();
        return proj;
    }

    public void save(Project project) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(project);
        transaction.commit();
        session.close();
    }

    public void update(Project project) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(project);
        transaction.commit();
        session.close();
    }
}
