package lk.ijse.hostelManagementSystem.bo.custom;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.bo.SuperBO;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;

public interface StudentBO extends SuperBO {

    void saveStudent(StudentDTO dto);

    void updateStudent(StudentDTO dto);

    StudentDTO searcStudent(String id);

    void deleteStudent(String id);
}