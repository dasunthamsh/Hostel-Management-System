package lk.ijse.hostelManagementSystem.dao.custom.impl;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.Entity.Student;
import lk.ijse.hostelManagementSystem.dao.custom.StudentDAO;
import lk.ijse.hostelManagementSystem.util.FactoryConfigeration;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.math.BigInteger;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean save(Student entity) {

        Session session = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean update(Student entity) {

        Session session = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return false;
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
    public boolean delete(String id) {
        Session session = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.get(Student.class ,id));
        transaction.commit();
        session.close();
        return  true;
    }

    public List<Student> getAll(){
        Session session = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List res = session.createQuery("FROM Student ").list();
        transaction.commit();
        session.close();
        return res;
    }

    @Override
    public List<Student> findAll() {
        Session session = FactoryConfigeration.getInstance().getSession();
        Query query = session.createQuery("from Student r");
        return query.list();
    }

    @Override
    public BigInteger getStudentJoinCount(String month) {
        Session session = FactoryConfigeration.getInstance().getSession();
        SQLQuery sqlQuery = session.createSQLQuery("select count(s.studentId) from Student s where s.dob like :month");
        sqlQuery.setParameter("month",month);
        return (BigInteger) sqlQuery.list().get(0);
    }
}
