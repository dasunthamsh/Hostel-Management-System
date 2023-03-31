package lk.ijse.hostelManagementSystem.dao.impl.custom;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.dao.impl.StudentDAOImpl;

public class DAOFactory {

    private static  DAOFactory daoFactory;

  private DAOFactory() {

  }
    public static DAOFactory getInstance(){
      return daoFactory == null ? daoFactory = new DAOFactory() : daoFactory;
    }


    public enum DAOTypes{
      STUDENT , ROOM
    }


    public SuperDAO getDAO(DAOTypes types){
      switch (types){
        case STUDENT:
          return new StudentDAOImpl();
        case ROOM:
          return new Ro
        default:
          return null;
      }
    }
}
