package lk.ijse.hostelManagementSystem.bo.custom;/*
    @author Dasun
*/


import lk.ijse.hostelManagementSystem.bo.SuperBO;
import lk.ijse.hostelManagementSystem.dto.CustomDTO;

import java.util.List;

public interface PaymentBo extends SuperBO {
    List<CustomDTO> lodeReservation();

    //  ArrayList<CustomDTO> getPendingPayments() ;

   // boolean updatePaymentStutes(String resId);

}
