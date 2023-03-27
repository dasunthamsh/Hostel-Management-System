package lk.ijse.hostelManagementSystem.util;/*
    @author Dasun
*/

import com.sun.deploy.security.SessionCertStore;
import lk.ijse.hostelManagementSystem.Controller.DashboardFormController;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {

    private static FactoryConfiguration factoryConfiguration;
    private  SessionFactory sessionFactory;

    private FactoryConfiguration(){
        sessionFactory = new Configuration().mergeProperties(Utility.getProperties())
                .addAnnotatedClass(DashboardFormController.class)
                .buildSessionFactory();
    }

    public FactoryConfiguration getInstance(){
        return (factoryConfiguration == null) ? new FactoryConfiguration() : factoryConfiguration;
    }
        public Session getSessino(){
            return sessionFactory.openSession();
        }

}
