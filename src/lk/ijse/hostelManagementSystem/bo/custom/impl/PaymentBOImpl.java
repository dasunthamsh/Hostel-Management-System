package lk.ijse.hostelManagementSystem.bo.custom.impl;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.bo.custom.PaymentBo;
import lk.ijse.hostelManagementSystem.dao.DAOFactory;
import lk.ijse.hostelManagementSystem.dao.custom.QueryDAO;
import lk.ijse.hostelManagementSystem.dto.CustomDTO;

import java.util.ArrayList;
import java.util.List;

public class PaymentBOImpl implements PaymentBo{

    private QueryDAO queryDAO = (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);

    @Override
    public List<CustomDTO> lodeReservation() {
        List<Object[]> pendingList = queryDAO.getPaymentStutas();
        List<CustomDTO> dto = new ArrayList<>();

       // for (Object[] pList: pendingList) {
           // dto.add(new CustomDTO((String)pList[0]  ,  (String)pList[1]  ,  (String)pList[2]  ,  (String)pList[3]  , (LocalDate) pList[4]));
        //}
        return dto;
    }
//    private ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RESEVATION);
//
//    @Override
//    public ArrayList<CustomDTO> getPendingPayments() {
//        return new ArrayList<CustomDTO>(queryDAO.getPaymentStutas().stream().map(o -> {
//            return new CustomDTO((String)o[0],(String)o[1],(String)o[2],(String)o[3],(String)o[4],(String)o[5] ); }).collect(Collectors.toList()));
//    }
//
//    @Override
//    public boolean updatePaymentStutes(String resId) {
//        Reservation reservation = reservationDAO.get(resId);
//        reservation.setStatus("Payed");
//        return reservationDAO.update(reservation);
//    }
}
