package lk.ijse.hostelManagementSystem.bo.custom.impl;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.Entity.Reservation;
import lk.ijse.hostelManagementSystem.Entity.Room;
import lk.ijse.hostelManagementSystem.Entity.Student;
import lk.ijse.hostelManagementSystem.bo.custom.ReservationBO;
import lk.ijse.hostelManagementSystem.dao.DAOFactory;
import lk.ijse.hostelManagementSystem.dao.custom.QueryDAO;
import lk.ijse.hostelManagementSystem.dao.custom.ReservationDAO;
import lk.ijse.hostelManagementSystem.dao.custom.RoomDAO;
import lk.ijse.hostelManagementSystem.dao.custom.StudentDAO;
import lk.ijse.hostelManagementSystem.dto.CustomDTO;
import lk.ijse.hostelManagementSystem.dto.ReservationDTO;
import lk.ijse.hostelManagementSystem.dto.RoomDTO;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationBOImpl implements ReservationBO {

    public ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RESEVATION);
    public StudentDAO studentDAO = (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);
    public RoomDAO roomDAO = (RoomDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ROOM);
    public QueryDAO queryDAO = (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);

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

    @Override
    public void deleteReservation(String id) {

    }

    @Override
    public ReservationDTO getReservation(String id) {

        Reservation reservation = reservationDAO.get(id);
        Student s = reservation.getStudent();
        Room r = reservation.getRoom();
        return new ReservationDTO(reservation.getResId(),reservation.getDate(),
        new StudentDTO(s.getStudentId(),s.getName(),s.getAddress(),s.getContactNo(),s.getDob(),s.getGender()),
                new RoomDTO(r.getRoomTpeId(),r.getType(),r.getKeyMoney(),r.getQyt()),
                reservation.getStatus());
    }

    @Override
    public List<CustomDTO> lodeReservation() {

        List<Object[]> pendList = queryDAO.getPaymentStutas();
        List<CustomDTO> dtos = new ArrayList<>();

        for (Object[] pList :pendList) {
            dtos.add(new CustomDTO((String)pList[0], (String)pList[1], (String)pList[2], (String)pList[3]));
        }
        return dtos;

      //  List<Object[]> pendingList =
       // ObservableList<ReseveationDTM> rooms = FXCollections.observableArrayList();
        //List<ReseveationDTM> all = ReservationDAO.lodeReservation();

//        ArrayList<Reservation> all = reservationDAO.lodeReservation();
//        for (ReseveationDTM room : all){
//            rooms.add(new ReseveationDTM(room.getResId(),room.getDate(),room.getStatus() , room.getRoomTpeId()),room.getStudentId());
//        }
//


       // return new ArrayList<CustomDTO>(reservationDAO.lodeReservation().stream().map(o -> { return new CustomDTO((String)o[0],(String)o[1],(String)o[2],(String)o[3],(String)o[4]);}).collect(Collectors.toList()));
    }

    @Override
    public boolean updatePaymentStutes(String resId) {
        return false;
    }


}
