package lk.ijse.hostelManagementSystem.bo.custom.impl;/*
    @author Dasun
*/

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.hostelManagementSystem.Entity.Room;
import lk.ijse.hostelManagementSystem.bo.custom.RoomBO;
import lk.ijse.hostelManagementSystem.dao.DAOFactory;
import lk.ijse.hostelManagementSystem.dao.custom.RoomDAO;
import lk.ijse.hostelManagementSystem.dto.RoomDTO;
import lk.ijse.hostelManagementSystem.view.dtm.RoomDTM;

import java.util.List;


public class RoomBOImpl implements RoomBO {

        public RoomDAO roomDAO = (RoomDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ROOM);

    @Override
    public boolean saveRoom(RoomDTO dto)throws Exception  {
        roomDAO.save(new Room(dto.getRoomTpeId(),dto.getType(),dto.getKeyMoney(),dto.getQyt()));

        return true;
    }

    @Override
    public boolean updateRoom(RoomDTO dto)throws Exception  {
        roomDAO.update(new Room(dto.getRoomTpeId(),dto.getType(),dto.getKeyMoney(),dto.getQyt()));
            return true;
    }

    @Override
    public RoomDTO searcRoom(String id)throws Exception {
        Room room = roomDAO.serch(id);
        return new RoomDTO(
                room.getRoomTpeId(),room.getType(),room.getQyt(),room.getKeyMoney());
    }

    @Override
    public boolean deleteRoom(String id)throws Exception {
        roomDAO.delete(id);
        return true;
    }


    @Override
    public ObservableList<RoomDTM> getRooms() {
        ObservableList<RoomDTM> rooms = FXCollections.observableArrayList();
        List<Room> all = roomDAO.getAll();
        for (Room room : all){
            rooms.add(new RoomDTM(room.getRoomTpeId(),room.getType(),room.getQyt(),room.getKeyMoney()));
        }

        return rooms;
    }
}
