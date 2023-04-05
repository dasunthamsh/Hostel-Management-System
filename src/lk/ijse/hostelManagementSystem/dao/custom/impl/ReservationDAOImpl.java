package lk.ijse.hostelManagementSystem.dao.custom.impl;/*
    @author Dasun
*/

import com.sun.xml.bind.v2.model.core.ID;
import lk.ijse.hostelManagementSystem.Entity.Reservation;
import lk.ijse.hostelManagementSystem.Entity.Room;
import lk.ijse.hostelManagementSystem.dao.ReservationDAO;
import lk.ijse.hostelManagementSystem.util.FactoryConfigeration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {
    @Override
    public void save(Reservation entity) {
        Session session = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        Room room = entity.getRoom();
        room.setQyt(room.getQyt()-1);
        session.update(room);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Reservation entity) {

    }

    @Override
    public Reservation serch(ID id) {
        return null;
    }

    @Override
    public void delete(ID id) {

    }

    @Override
    public void getStudentId(Reservation enty) {

    }

    @Override
    public void getRoomId(Reservation enty) {

    }

    @Override
    public String getResevetionId() {
        Session session = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<String> list = session.createQuery("SELECT resId FROM Reservation ORDER BY resId DESC ").setMaxResults(1).list();
        transaction.commit();
        session.close();
        return list.size()>0? String.format("#R%3d",Integer.parseInt(list.get(0).replace("#R",""))+1):"#R001";    }


}
