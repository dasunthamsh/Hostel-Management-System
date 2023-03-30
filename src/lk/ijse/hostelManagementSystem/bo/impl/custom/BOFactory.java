package lk.ijse.hostelManagementSystem.bo.impl.custom;/*
    @author Dasun
*/

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory(){

    }

    public static BOFactory getInstance(){
        return boFactory == null ? boFactory = new BOFactory() : boFactory;
    }

    public
}
