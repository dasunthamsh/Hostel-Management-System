package lk.ijse.hostelManagementSystem.bo.custom.impl;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.Entity.Room;
import lk.ijse.hostelManagementSystem.bo.RoomBO;
import lk.ijse.hostelManagementSystem.dao.RoomDAO;
import lk.ijse.hostelManagementSystem.dao.custom.DAOFactory;
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
        Room room = roomDAO.serch(id);
        return new RoomDTO(
                room.getRoomTpeId(),room.getType(),room.getQyt(),room.getKeyMoney());
    }

    @Override
    public void deleteRoom(String id) {
        roomDAO.delete(id);
    }
}
