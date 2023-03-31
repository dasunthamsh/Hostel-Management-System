package lk.ijse.hostelManagementSystem.bo;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.bo.impl.custom.SuperBO;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;

public interface StudentBO extends SuperBO  {

    void saveStudent(StudentDTO dto);

    void updateStudent(StudentDTO dto);

    void searcStudent(String id);

    void deleteStudent(String id);
}
