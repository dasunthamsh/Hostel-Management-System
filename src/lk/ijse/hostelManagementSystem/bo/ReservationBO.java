package lk.ijse.hostelManagementSystem.bo;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.Entity.Reservation;
import lk.ijse.hostelManagementSystem.bo.impl.custom.SuperBO;
import lk.ijse.hostelManagementSystem.dto.ReservationDTO;

public interface ReservationBO extends SuperBO {

    void saveReservation(ReservationDTO dto);

    void getStudentId(ReservationDTO dto);
}
