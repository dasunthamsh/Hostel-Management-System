package lk.ijse.hostelManagementSystem.bo.custom.impl;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.Entity.Regester;
import lk.ijse.hostelManagementSystem.bo.custom.RegesterBO;
import lk.ijse.hostelManagementSystem.dao.DAOFactory;
import lk.ijse.hostelManagementSystem.dao.custom.RegesterDAO;
import lk.ijse.hostelManagementSystem.dto.RegesterDTO;

import java.util.HashMap;

public class RegesterBOImpl implements RegesterBO {

    RegesterDAO regesterDAO = (RegesterDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.REGESTER);

    @Override
    public boolean saveUser(RegesterDTO dto)throws Exception  {
        regesterDAO.save(new Regester(dto.getId(),dto.getName(),dto.getEmail(), dto.getPassword()));
        return true;
    }

    @Override
    public boolean updateUser(RegesterDTO dto)throws Exception  {
        regesterDAO.update(new Regester(dto.getId(), dto.getPassword()));
        return true;
    }

    @Override
    public boolean checkPassword(String email, String password) {
        HashMap<String,String> allUsers =regesterDAO.getAllUserNPasswordMap();
        if(allUsers.containsKey(email)){
            return allUsers.get(email).equals(password);

        }else {

        }
        return false;
    }
}
