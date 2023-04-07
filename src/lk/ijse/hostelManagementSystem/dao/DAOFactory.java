package lk.ijse.hostelManagementSystem.dao;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.dao.custom.impl.RegesterDAOimpl;
import lk.ijse.hostelManagementSystem.dao.custom.impl.ReservationDAOImpl;
import lk.ijse.hostelManagementSystem.dao.custom.impl.RoomDAOImpl;
import lk.ijse.hostelManagementSystem.dao.custom.impl.StudentDAOImpl;

public class DAOFactory {

    private static  DAOFactory daoFactory;

  private DAOFactory() {

  }
    public static DAOFactory getInstance(){
      return daoFactory == null ? daoFactory = new DAOFactory() : daoFactory;
    }


    public enum DAOTypes{
      STUDENT , ROOM , RESEVATION ,REGESTER
    }


    public SuperDAO getDAO(DAOTypes types){
      switch (types){
        case STUDENT:
          return new StudentDAOImpl();
        case ROOM:
          return new RoomDAOImpl();
        case RESEVATION:
          return new ReservationDAOImpl();
        case REGESTER:
          return new RegesterDAOimpl();
        default:
          return null;
      }
    }
}
