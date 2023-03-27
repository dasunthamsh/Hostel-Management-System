package lk.ijse.hostelManagementSystem.util;/*
    @author Dasun
*/

import java.io.IOException;
import java.util.Properties;

public class Utility {

    public static Properties getProperties(){
        Properties properties = new Properties();

        try {
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("hibernate.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
