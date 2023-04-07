package lk.ijse.hostelManagementSystem.bo.custom.impl;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.Entity.Regester;
import lk.ijse.hostelManagementSystem.bo.custom.RegesterBO;
import lk.ijse.hostelManagementSystem.dao.DAOFactory;
import lk.ijse.hostelManagementSystem.dao.custom.RegesterDAO;
import lk.ijse.hostelManagementSystem.dto.RegesterDTO;

public class RegesterBOImpl implements RegesterBO {

    RegesterDAO regesterDAO = (RegesterDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.REGESTER);

    @Override
    public boolean saveUser(RegesterDTO dto) {
        regesterDAO.save(new Regester(dto.getId(),dto.getName(),dto.getEmail(), dto.getPassword()));
        return true;
    }
}
