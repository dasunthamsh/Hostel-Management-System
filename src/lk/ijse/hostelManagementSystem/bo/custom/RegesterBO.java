package lk.ijse.hostelManagementSystem.bo.custom;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.bo.SuperBO;
import lk.ijse.hostelManagementSystem.dto.RegesterDTO;

public interface RegesterBO extends SuperBO {

    boolean saveUser(RegesterDTO dto);

    boolean updateUser(String id , String password);

    boolean checkPassword(String email , String password);
}
