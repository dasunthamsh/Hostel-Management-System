package lk.ijse.hostelManagementSystem.bo.custom;/*
    @author Dasun
*/

import javafx.collections.ObservableList;
import lk.ijse.hostelManagementSystem.bo.SuperBO;
import lk.ijse.hostelManagementSystem.dto.RoomDTO;
import lk.ijse.hostelManagementSystem.view.dtm.RoomDTM;

public interface RoomBO extends SuperBO {

    boolean saveRoom(RoomDTO dto)throws Exception ;

    boolean updateRoom(RoomDTO dto)throws Exception ;

    RoomDTO searcRoom(String id)throws Exception;

    boolean deleteRoom(String id) throws Exception;

    ObservableList<RoomDTM> getRooms();
}
