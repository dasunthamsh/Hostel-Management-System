package lk.ijse.hostelManagementSystem.dao.custom;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.Entity.Room;
import lk.ijse.hostelManagementSystem.dao.CrudDAO;

import java.util.List;

public interface RoomDAO extends CrudDAO<Room , String> {

     List<Room> getAll();
}
