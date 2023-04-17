package lk.ijse.hostelManagementSystem.dao.custom.impl;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.Entity.Regester;
import lk.ijse.hostelManagementSystem.dao.custom.RegesterDAO;
import lk.ijse.hostelManagementSystem.util.FactoryConfigeration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashMap;
import java.util.List;

public class RegesterDAOimpl implements RegesterDAO {
    @Override
    public boolean save(Regester entity) {
        Session session = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Regester regester) {
        Session session = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(regester);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public HashMap<String, String> getAllUserNPasswordMap() {
        Session session = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<Object[]> list = session.createQuery("SELECT id , password FROM Regester ").list();
        transaction.commit();
        session.close();
        HashMap<String,String> userMap = new HashMap<>();
        list.stream().forEach(o -> userMap.put((String)o[0],(String) o[1]));
        return userMap;
    }
}
