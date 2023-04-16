package lk.ijse.hostelManagementSystem.bo.custom.impl;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.bo.custom.PaymentBo;
import lk.ijse.hostelManagementSystem.dao.DAOFactory;
import lk.ijse.hostelManagementSystem.dao.custom.QueryDAO;

import java.util.List;

public class PaymentBOImpl implements PaymentBo{

    private QueryDAO queryDAO = (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);


    @Override
    public List<Object[]> getPendingKeyPayments() {
        return null;
    }

    @Override
    public boolean updatePayment(String resId) {
        return false;
    }
}
