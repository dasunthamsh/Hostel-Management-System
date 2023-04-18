package lk.ijse.hostelManagementSystem.bo.custom.impl;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.bo.custom.DashboardBO;
import lk.ijse.hostelManagementSystem.dao.DAOFactory;
import lk.ijse.hostelManagementSystem.dao.custom.DashboardDAO;
import lk.ijse.hostelManagementSystem.dao.custom.StudentDAO;

public class DashboardBOImpl implements DashboardBO {

    DashboardDAO dashboardDAO = (DashboardDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.DASHBOARD);
    public StudentDAO studentDAO = (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);



}
