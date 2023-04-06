package lk.ijse.hostelManagementSystem.bo;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.bo.custom.impl.PaymentBOImpl;
import lk.ijse.hostelManagementSystem.bo.custom.impl.ReservationBOImpl;
import lk.ijse.hostelManagementSystem.bo.custom.impl.RoomBOImpl;
import lk.ijse.hostelManagementSystem.bo.custom.impl.StudentBOImpl;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory(){

    }

    public enum BOTypes{
        STUDENT , ROOM , RESEVATION ,PAYMENT
    }

    public SuperBO getBO(BOTypes types){
        switch (types){
            case STUDENT:
                return new StudentBOImpl();

            case ROOM:
                return new RoomBOImpl();
            case RESEVATION:
                return new ReservationBOImpl();
            case PAYMENT:
                return new PaymentBOImpl();
            default:

                return null;
        }
    }

    public static BOFactory getInstance(){
        return boFactory == null ? boFactory = new BOFactory() : boFactory;
    }


}
