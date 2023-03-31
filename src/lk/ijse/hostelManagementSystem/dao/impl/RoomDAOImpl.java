package lk.ijse.hostelManagementSystem.dao.impl;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.Entity.Room;
import lk.ijse.hostelManagementSystem.Entity.Student;
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
        Session session = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();

    }

    @Override
    public Room serch(String id) {
        Session session = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Room room = session.get(Room.class,id);
        transaction.commit();
        session.close();
        return room;
    }

    @Override
    public void delete(String id) {
        Session session = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.get(Room.class,id));
        transaction.commit();
        session.close();

    }
}
