package lk.ijse.hostelManagementSystem.bo.custom;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.bo.SuperBO;
import lk.ijse.hostelManagementSystem.dto.RegesterDTO;

public interface RegesterBO extends SuperBO {

    boolean saveUser(RegesterDTO dto);

    boolean updateUser(RegesterDTO regesterDTO);

    boolean checkPassword(String email , String password);
}
