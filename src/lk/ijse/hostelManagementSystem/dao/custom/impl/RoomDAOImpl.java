package lk.ijse.hostelManagementSystem.dao.custom.impl;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.Entity.Room;
import lk.ijse.hostelManagementSystem.dao.custom.RoomDAO;
import lk.ijse.hostelManagementSystem.util.FactoryConfigeration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public boolean save(Room entity) throws Exception{
        Session session = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Room entity) throws Exception{
        Session session = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();

        return false;
    }

    @Override
    public Room serch(String id)throws Exception {
        Session session = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Room room = session.get(Room.class,id);
        transaction.commit();
        session.close();
        return room;
    }

    @Override
    public boolean delete(String id)throws Exception {
        Session session = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.get(Room.class,id));
        transaction.commit();
        session.close();
        return  true;

    }
    @Override
    public List<Room> getAll(){
        Session session = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List res = session.createQuery("FROM Room ").list();
        transaction.commit();
        session.close();
        return res;
    }
}
