package lk.ijse.hostelManagementSystem.bo.custom.impl;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.Entity.Reservation;
import lk.ijse.hostelManagementSystem.Entity.Room;
import lk.ijse.hostelManagementSystem.Entity.Student;
import lk.ijse.hostelManagementSystem.bo.custom.ReservationBO;
import lk.ijse.hostelManagementSystem.dao.custom.ReservationDAO;
import lk.ijse.hostelManagementSystem.dao.custom.RoomDAO;
import lk.ijse.hostelManagementSystem.dao.custom.StudentDAO;
import lk.ijse.hostelManagementSystem.dao.DAOFactory;
import lk.ijse.hostelManagementSystem.dto.ReservationDTO;
import lk.ijse.hostelManagementSystem.dto.RoomDTO;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ReservationBOImpl implements ReservationBO {

    public ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RESEVATION);
    public StudentDAO studentDAO = (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);
    public RoomDAO roomDAO = (RoomDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ROOM);

    @Override
    public void saveReservation(ReservationDTO dto) {
        StudentDTO s1 = dto.getStudent();
        RoomDTO r1 = dto.getRoom();

        reservationDAO.save(new Reservation(dto.getResId(),dto.getDate(),
            new Student(s1.getStudentId(),s1.getName(),s1.getAddress(),s1.getContactNo(),s1.getDob(),s1.getGender()),
            new Room(r1.getRoomTpeId(),r1.getType(),r1.getKeyMoney(),r1.getQyt()),dto.getStatus()));

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
        return new ArrayList<String>(roomDAO.getAll().stream().map(room -> {return room.getRoomTpeId();
        }).collect(Collectors.toList()));
    }

    @Override
    public RoomDTO serchRoom(String id) {
        Room room =roomDAO.serch(id);
        return new RoomDTO(room.getRoomTpeId(),room.getType(),room.getQyt(), room.getKeyMoney());
    }

    @Override
    public String getResevationId() {
        return reservationDAO.getResevetionId();
    }


}
