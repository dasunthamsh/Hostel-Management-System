package lk.ijse.hostelManagementSystem.bo.custom.impl;/*
    @author Dasun
*/

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.hostelManagementSystem.Entity.Student;
import lk.ijse.hostelManagementSystem.bo.custom.StudentBO;
import lk.ijse.hostelManagementSystem.dao.DAOFactory;
import lk.ijse.hostelManagementSystem.dao.custom.StudentDAO;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;
import lk.ijse.hostelManagementSystem.view.dtm.StudentDTM;

import java.util.List;

public class StudentBOImpl implements StudentBO {

    public StudentDAO studentDAO = (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);


    @Override
    public boolean saveStudent(StudentDTO dto) {
        studentDAO.save(new Student(dto.getStudentId(),dto.getName(),dto.getAddress(),dto.getContactNo(),dto.getDob(),dto.getGender()));
        return true;
    }

    @Override
    public boolean updateStudent(StudentDTO dto) {
        studentDAO.update(new Student(dto.getStudentId(),dto.getName(),dto.getAddress(),dto.getContactNo(),dto.getDob(),dto.getGender()));
    return true;
    }

    @Override
    public StudentDTO searcStudent(String id) {
        Student student = studentDAO.serch(id);
        return new StudentDTO(
                student.getStudentId(),student.getName(),student.getAddress(),student.getContactNo(),student.getDob(),student.getGender()
        );
    }

    @Override
    public boolean deleteStudent(String id) {
        studentDAO.delete(id);
        return true;
    }

    @Override
    public ObservableList<StudentDTM> getStudents() {
        ObservableList<StudentDTM> students = FXCollections.observableArrayList();
        List<Student> all = studentDAO.getAll();
        for(Student student : all){
            students.add(new StudentDTM(student.getStudentId(),student.getName(),student.getAddress(),student.getContactNo(),student.getDob(),student.getGender()));
        }
        return students;
    }
}
