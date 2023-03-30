package lk.ijse.hostelManagementSystem.util;/*
    @author Dasun
*/
import lk.ijse.hostelManagementSystem.Entity.Reservation;
import lk.ijse.hostelManagementSystem.Entity.Room;
import lk.ijse.hostelManagementSystem.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class FactoryConfigeration {
    private static FactoryConfigeration factoryConfigeration;
    private SessionFactory sessionFactory;

    private FactoryConfigeration(){
        sessionFactory = new Configuration().mergeProperties(Utility.getProperties())
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Room.class)
                .addAnnotatedClass(Reservation.class)
                .buildSessionFactory();
    }

    public static FactoryConfigeration getInstance(){
        return (factoryConfigeration==null)?factoryConfigeration=new FactoryConfigeration()
                : factoryConfigeration;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}
