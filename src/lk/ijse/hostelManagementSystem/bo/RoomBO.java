package lk.ijse.hostelManagementSystem.bo;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.bo.impl.custom.SuperBO;
import lk.ijse.hostelManagementSystem.dto.RoomDTO;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;

public interface RoomBO extends SuperBO {

    void saveRoom(RoomDTO dto);

    void updateRoom(RoomDTO dto);

    RoomDTO searcRoom(String id);

    void deleteRoom(String id);
}
