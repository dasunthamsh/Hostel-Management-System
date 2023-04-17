package lk.ijse.hostelManagementSystem.dao.custom;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.Entity.Regester;
import lk.ijse.hostelManagementSystem.dao.SuperDAO;

import java.util.HashMap;

public interface RegesterDAO extends SuperDAO {

    boolean save(Regester entity);

    boolean update(Regester regester);

    HashMap<String, String> getAllUserNPasswordMap();
}
