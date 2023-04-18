package lk.ijse.hostelManagementSystem.dao.custom;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.Entity.Student;
import lk.ijse.hostelManagementSystem.dao.SuperDAO;

import java.util.List;

public interface DashboardDAO extends SuperDAO {

    List<Student> getcount();
}
