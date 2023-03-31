package lk.ijse.hostelManagementSystem.bo.impl;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.Entity.Student;
import lk.ijse.hostelManagementSystem.bo.StudentBO;
import lk.ijse.hostelManagementSystem.bo.impl.custom.SuperBO;
import lk.ijse.hostelManagementSystem.dao.StudentDAO;
import lk.ijse.hostelManagementSystem.dao.impl.custom.DAOFactory;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;

public class StudentBOImpl implements StudentBO {

    public StudentDAO studentDAO = (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);


    @Override
    public void saveStudent(StudentDTO dto) {
        studentDAO.save(new Student(dto.getStudentId(),dto.getName(),dto.getAddress(),dto.getContactNo(),dto.getDob(),dto.getGender()));

    }

    @Override
    public void updateStudent(StudentDTO dto) {

    }

    @Override
    public void searcStudent(String id) {

    }

    @Override
    public void deleteStudent(String id) {

    }
}
