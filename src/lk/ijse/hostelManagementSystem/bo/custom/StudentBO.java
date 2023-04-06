package lk.ijse.hostelManagementSystem.bo.custom;/*
    @author Dasun
*/

import javafx.collections.ObservableList;
import lk.ijse.hostelManagementSystem.bo.SuperBO;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;
import lk.ijse.hostelManagementSystem.tm.RoomTM;
import lk.ijse.hostelManagementSystem.tm.StudentTM;

public interface StudentBO extends SuperBO {

    void saveStudent(StudentDTO dto);

    void updateStudent(StudentDTO dto);

    StudentDTO searcStudent(String id);

    void deleteStudent(String id);

    ObservableList<StudentTM> getStudents();
}
