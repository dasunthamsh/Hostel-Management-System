package lk.ijse.hostelManagementSystem.bo.custom.impl;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.Entity.Reservation;
import lk.ijse.hostelManagementSystem.bo.custom.PaymentBo;
import lk.ijse.hostelManagementSystem.dao.DAOFactory;
import lk.ijse.hostelManagementSystem.dao.custom.QueryDAO;
import lk.ijse.hostelManagementSystem.dao.custom.ReservationDAO;
import lk.ijse.hostelManagementSystem.dto.CustomDTO;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PaymentBOImpl implements PaymentBo{

    private QueryDAO queryDAO = (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);
    private ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RESEVATION);

    @Override
    public ArrayList<CustomDTO> getPendingPayments() {
        return new ArrayList<CustomDTO>(queryDAO.getPaymentStutas().stream().map(o -> {
            return new CustomDTO((String)o[0],(String)o[1],(String)o[2],(String)o[3],(String)o[4],(String)o[5] ); }).collect(Collectors.toList()));
    }

    @Override
    public boolean updatePaymentStutes(String resId) {
        Reservation reservation = reservationDAO.get(resId);
        reservation.setStatus("Payed");
        return reservationDAO.update(reservation);
    }
}
