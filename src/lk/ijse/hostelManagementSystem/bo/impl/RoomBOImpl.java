package lk.ijse.hostelManagementSystem.bo.impl;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.Entity.Room;
import lk.ijse.hostelManagementSystem.bo.RoomBO;
import lk.ijse.hostelManagementSystem.dao.RoomDAO;
import lk.ijse.hostelManagementSystem.dao.impl.custom.DAOFactory;
import lk.ijse.hostelManagementSystem.dto.RoomDTO;


public class RoomBOImpl implements RoomBO {

        public RoomDAO roomDAO = (RoomDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ROOM);

    @Override
    public void saveRoom(RoomDTO dto) {
        roomDAO.save(new Room(dto.getRoomTpeId(),dto.getType(),dto.getKeyMoney(),dto.getQyt()));
    }

    @Override
    public void updateRoom(RoomDTO dto) {
        roomDAO.update(new Room(dto.getRoomTpeId(),dto.getType(),dto.getKeyMoney(),dto.getQyt()));

    }

    @Override
    public RoomDTO searcRoom(String id) {
        return null;
    }

    @Override
    public void deleteRoom(String id) {

    }
}
