package lk.ijse.hostelManagementSystem.dao.impl;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.Entity.Room;
import lk.ijse.hostelManagementSystem.dao.RoomDAO;
import lk.ijse.hostelManagementSystem.util.FactoryConfigeration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public void save(Room entity) {
        Session session = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Room entity) {

    }

    @Override
    public Room serch(String s) {
        return null;
    }

    @Override
    public void delete(String s) {

    }
}
