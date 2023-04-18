package lk.ijse.hostelManagementSystem.bo.custom;/*
    @author Dasun
*/

import javafx.collections.ObservableList;
import lk.ijse.hostelManagementSystem.bo.SuperBO;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;
import lk.ijse.hostelManagementSystem.view.dtm.StudentDTM;

import java.math.BigInteger;
import java.util.List;

public interface StudentBO extends SuperBO {

    boolean saveStudent(StudentDTO dto);

    boolean updateStudent(StudentDTO dto);

    StudentDTO searcStudent(String id);

    boolean deleteStudent(String id);

    ObservableList<StudentDTM> getStudents();

    List<StudentDTO> getAllStudents();

    BigInteger getStudentJoinCount(String month);
}
