package lk.ijse.hostelManagementSystem.bo.custom.impl;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.Entity.Student;
import lk.ijse.hostelManagementSystem.bo.custom.StudentBO;
import lk.ijse.hostelManagementSystem.dao.custom.StudentDAO;
import lk.ijse.hostelManagementSystem.dao.DAOFactory;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;

public class StudentBOImpl implements StudentBO {

    public StudentDAO studentDAO = (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);


    @Override
    public void saveStudent(StudentDTO dto) {
        studentDAO.save(new Student(dto.getStudentId(),dto.getName(),dto.getAddress(),dto.getContactNo(),dto.getDob(),dto.getGender()));

    }

    @Override
    public void updateStudent(StudentDTO dto) {
        studentDAO.update(new Student(dto.getStudentId(),dto.getName(),dto.getAddress(),dto.getContactNo(),dto.getDob(),dto.getGender()));

    }

    @Override
    public StudentDTO searcStudent(String id) {
        Student student = studentDAO.serch(id);
        return new StudentDTO(
                student.getStudentId(),student.getName(),student.getAddress(),student.getContactNo(),student.getDob(),student.getGender()
        );
    }

    @Override
    public void deleteStudent(String id) {
        studentDAO.delete(id);
    }
}
