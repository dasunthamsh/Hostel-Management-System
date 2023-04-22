package lk.ijse.hostelManagementSystem.bo.custom.impl;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.Entity.Reservation;
import lk.ijse.hostelManagementSystem.bo.custom.PaymentBo;
import lk.ijse.hostelManagementSystem.dao.DAOFactory;
import lk.ijse.hostelManagementSystem.dao.custom.QueryDAO;
import lk.ijse.hostelManagementSystem.dao.custom.ReservationDAO;

import java.util.List;

public class PaymentBOImpl implements PaymentBo{

    QueryDAO queryDAO = (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);
    ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RESEVATION);


    @Override
    public List<Object[]> getPendingKeyPayments() {
        return queryDAO.getPaymentStutas();
    }

    @Override
    public boolean updatePayment(String resId) {
        Reservation reservation = reservationDAO.get(resId);
        reservation.setStatus("payed");
        try {
            return reservationDAO.update(reservation);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
