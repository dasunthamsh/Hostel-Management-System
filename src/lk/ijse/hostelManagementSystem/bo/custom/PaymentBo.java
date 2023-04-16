package lk.ijse.hostelManagementSystem.bo.custom;/*
    @author Dasun
*/


import lk.ijse.hostelManagementSystem.bo.SuperBO;

import java.util.List;

public interface PaymentBo extends SuperBO {

   List<Object[]> getPendingKeyPayments();

   boolean updatePayment(String resId);

}
