package lk.ijse.hostelManagementSystem.bo.impl.custom;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.bo.impl.RoomBOImpl;
import lk.ijse.hostelManagementSystem.bo.impl.StudentBOImpl;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory(){

    }

    public enum BOTypes{
        STUDENT , ROOM
    }

    public SuperBO getBO(BOTypes types){
        switch (types){
            case STUDENT:
                return new StudentBOImpl();

            case ROOM:
                return new RoomBOImpl();
            default:
                return null;
        }
    }

    public static BOFactory getInstance(){
        return boFactory == null ? boFactory = new BOFactory() : boFactory;
    }


}
