package lk.ijse.hostelManagementSystem.bo;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.bo.custom.impl.*;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory(){

    }

    public enum BOTypes{
        STUDENT , ROOM , RESEVATION ,PAYMENT , REGESTER , DASHBOARD
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
            case REGESTER:
                return new RegesterBOImpl();
            case DASHBOARD:
                return new DashboardBOImpl();

            default:

                return null;
        }
    }

    public static BOFactory getInstance(){
        return boFactory == null ? boFactory = new BOFactory() : boFactory;
    }


}
