package lk.ijse.hostelManagementSystem.bo.impl;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.Entity.Student;
import lk.ijse.hostelManagementSystem.bo.ReservationBO;
import lk.ijse.hostelManagementSystem.dao.ReservationDAO;
import lk.ijse.hostelManagementSystem.dao.StudentDAO;
import lk.ijse.hostelManagementSystem.dao.impl.custom.DAOFactory;
import lk.ijse.hostelManagementSystem.dto.ReservationDTO;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationBOImpl implements ReservationBO {

    public ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RESEVATION);

    public StudentDAO studentDAO = (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public void saveReservation(ReservationDTO dto) {

    }

    @Override
    public ArrayList<String> getStudentIds() {
    return new ArrayList<String>(studentDAO.getAll().stream().map(student -> {return student.getStudentId();
    }).collect(Collectors.toList()));
    }

    @Override
    public StudentDTO serchStudent(String id) {
        Student serch = studentDAO.serch(id);

        return new StudentDTO(serch.getStudentId(),serch.getName(),serch.getAddress(),serch.getContactNo(),serch.getDob(),serch.getGender());
    }

    @Override
    public ArrayList<String> getRoomIds() {
        return null;
    }

    @Override
    public StudentDTO serchRoom(String id) {
        return null;
    }


}
