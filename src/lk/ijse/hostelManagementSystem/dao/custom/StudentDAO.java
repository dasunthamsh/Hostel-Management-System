package lk.ijse.hostelManagementSystem.dao.custom;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.Entity.Student;
import lk.ijse.hostelManagementSystem.dao.CrudDAO;

import java.math.BigInteger;
import java.util.List;

public interface StudentDAO extends CrudDAO<Student , String> {

     List<Student> getAll();

    List<Student> findAll();

    BigInteger getStudentJoinCount(String month);

    List<String> lodeId();
}
