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
        List<Object[]> list =session.createQuery("SELECT res.resId,s.studentId,s.name, r.roomTpeId, r.type, res.status FROM Reservation res JOIN Student s ON res.student=s.studentId JOIN Room r ON res.room=r.roomTpeId WHERE res.status='Pending'").list();
        transaction.commit();
        session.close();
        return list;
    }
}
