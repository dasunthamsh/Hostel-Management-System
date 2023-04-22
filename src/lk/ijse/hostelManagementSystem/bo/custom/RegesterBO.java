package lk.ijse.hostelManagementSystem.bo.custom;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.bo.SuperBO;
import lk.ijse.hostelManagementSystem.dto.RegesterDTO;

public interface RegesterBO extends SuperBO {

    boolean saveUser(RegesterDTO dto)throws Exception ;

    boolean updateUser(RegesterDTO regesterDTO)throws Exception ;

    boolean checkPassword(String email , String password);
}
