package lk.ijse.hostelManagementSystem.Controller;/*
    @author Dasun
*/

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;

import lk.ijse.hostelManagementSystem.util.FactoryConfigeration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ManageRoomFormController {

    public JFXTextField txtRoomTypeID;
    public JFXButton btnAddRoom;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtRoomType;
    public JFXTextField txtQyt;




    public void btnAddRoomOnAction(ActionEvent actionEvent) {
        Session session = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
//       session.save();
        transaction.commit();
        session.close();
    }

}
