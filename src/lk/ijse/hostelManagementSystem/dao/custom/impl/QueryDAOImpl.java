package lk.ijse.hostelManagementSystem.dao.custom.impl;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.dao.custom.QueryDAO;
import lk.ijse.hostelManagementSystem.util.FactoryConfigeration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class QueryDAOImpl implements QueryDAO {

    @Override
    public List<Object[]> getPaymentStutas() {
        Session session = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List <Object[]>list = session.createQuery("SELECT s.studentId FROM Student s INNER JOIN Reservation res ON s.studentId = res.student INNER JOIN Room r ON r.roomTpeId = res.room WHERE res.status ='pending'").list();
        transaction.commit();
        session.close();
        return list;
    }
}
