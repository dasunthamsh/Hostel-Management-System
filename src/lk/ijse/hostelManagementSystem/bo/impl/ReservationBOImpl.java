package lk.ijse.hostelManagementSystem.bo.impl;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.bo.ReservationBO;
import lk.ijse.hostelManagementSystem.dao.ReservationDAO;
import lk.ijse.hostelManagementSystem.dao.impl.custom.DAOFactory;
import lk.ijse.hostelManagementSystem.dto.ReservationDTO;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;

import java.util.ArrayList;

public class ReservationBOImpl implements ReservationBO {

    public ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RESEVATION);

    @Override
    public void saveReservation(ReservationDTO dto) {

    }

    @Override
    public StudentDTO getStudentId(Object newValue) {
        return new ArrayList<String>(reservationDAO.g);
    }


}
