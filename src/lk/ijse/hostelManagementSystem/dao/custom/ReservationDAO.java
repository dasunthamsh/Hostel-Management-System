package lk.ijse.hostelManagementSystem.dao.custom;/*
    @author Dasun
*/

import com.sun.xml.bind.v2.model.core.ID;
import lk.ijse.hostelManagementSystem.Entity.Reservation;
import lk.ijse.hostelManagementSystem.dao.CrudDAO;
import lk.ijse.hostelManagementSystem.view.dtm.ReseveationDTM;

import java.util.List;

public interface ReservationDAO extends CrudDAO<Reservation, ID> {

    void getStudentId(Reservation enty);

    void getRoomId(Reservation enty);

    String getResevetionId();

    Reservation get(String id);

    // static List<Object> lodeReservation();

    List<ReseveationDTM> lodeReservation();
}
