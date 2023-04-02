package lk.ijse.hostelManagementSystem.dao;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.Entity.Room;
import lk.ijse.hostelManagementSystem.Entity.Student;

import java.util.List;

public interface RoomDAO extends CrudDAO<Room , String>{

     List<Room> getAll();
}
