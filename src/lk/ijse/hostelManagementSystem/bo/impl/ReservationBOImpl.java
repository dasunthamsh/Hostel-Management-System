package lk.ijse.hostelManagementSystem.bo.impl;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.bo.ReservationBO;
import lk.ijse.hostelManagementSystem.dao.ReservationDAO;
import lk.ijse.hostelManagementSystem.dao.impl.custom.DAOFactory;
import lk.ijse.hostelManagementSystem.dto.ReservationDTO;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ReservationBOImpl implements ReservationBO {

    public ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RESEVATION);

    @Override
    public void saveReservation(ReservationDTO dto) {

    }

    @Override
    public ArrayList<String> getStudentIds() {
        return null;
    }


}
