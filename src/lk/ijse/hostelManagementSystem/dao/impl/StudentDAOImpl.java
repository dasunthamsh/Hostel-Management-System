package lk.ijse.hostelManagementSystem.dao.impl;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.Entity.Student;
import lk.ijse.hostelManagementSystem.dao.StudentDAO;
import lk.ijse.hostelManagementSystem.dao.impl.custom.SuperDAO;
import lk.ijse.hostelManagementSystem.util.FactoryConfigeration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public void save(Student entity) {

        Session session = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Student entity) {

        Session session = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public Student serch(String id) {
        Session session = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class ,id);
        transaction.commit();
        session.close();
        return student;
    }

    @Override
    public void delete(String s) {

    }
}
