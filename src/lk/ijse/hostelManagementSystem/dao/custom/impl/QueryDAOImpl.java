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
        List<Object[]> list =session.createQuery("SELECT reservation.resId,s.studentId,s.name,r.roomTpeId , r.type , reservation.status FROM Reservation reservation JOIN Student s ON reservation.student=s.studentId JOIN Room r ON reservation.room=r.roomTpeId WHERE reservation.status='Pending'").list();
        transaction.commit();
        session.close();
        return list;
    }
}
