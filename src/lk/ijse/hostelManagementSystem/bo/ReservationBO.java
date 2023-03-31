package lk.ijse.hostelManagementSystem.bo;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.Entity.Reservation;
import lk.ijse.hostelManagementSystem.bo.impl.custom.SuperBO;
import lk.ijse.hostelManagementSystem.dto.ReservationDTO;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;

import java.util.ArrayList;

public interface ReservationBO extends SuperBO {

    void saveReservation(ReservationDTO dto);


    StudentDTO getStudentId(Object newValue);
}
