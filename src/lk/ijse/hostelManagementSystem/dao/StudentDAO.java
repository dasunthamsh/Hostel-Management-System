package lk.ijse.hostelManagementSystem.dao;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.Entity.Student;

import java.util.List;

public interface StudentDAO extends CrudDAO<Student , String>{

     List<Student> getAll();
}
