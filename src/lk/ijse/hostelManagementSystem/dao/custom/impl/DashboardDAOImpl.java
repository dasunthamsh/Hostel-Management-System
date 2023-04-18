package lk.ijse.hostelManagementSystem.dao.custom.impl;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.Entity.Student;
import lk.ijse.hostelManagementSystem.dao.custom.DashboardDAO;
import lk.ijse.hostelManagementSystem.util.FactoryConfigeration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class DashboardDAOImpl implements DashboardDAO {



    @Override
    public List<Student> getcount() {
        Session session = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Student s");
        transaction.commit();
        session.close();
        return query.list();
    }
}
