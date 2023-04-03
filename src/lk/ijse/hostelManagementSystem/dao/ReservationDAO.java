package lk.ijse.hostelManagementSystem.dao;/*
    @author Dasun
*/

import com.sun.xml.bind.v2.model.core.ID;
import lk.ijse.hostelManagementSystem.Entity.Reservation;

public interface ReservationDAO extends CrudDAO<Reservation, ID>{

    void getStudentId(Reservation enty);

    void getRoomId(Reservation enty);

    String getResevetionId();
}
