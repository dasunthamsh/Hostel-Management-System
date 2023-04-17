package lk.ijse.hostelManagementSystem.bo.custom;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.bo.SuperBO;
import lk.ijse.hostelManagementSystem.dto.ReservationDTO;
import lk.ijse.hostelManagementSystem.dto.RoomDTO;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;

import java.util.ArrayList;

public interface ReservationBO extends SuperBO {

    boolean saveReservation(ReservationDTO dto);

     ArrayList<String> getStudentIds();

     StudentDTO serchStudent(String id);

     ArrayList<String> getRoomIds();

      RoomDTO serchRoom(String id);

      String getResevationId();

      void deleteReservation(String id);

       ReservationDTO getReservation(String id);

}
