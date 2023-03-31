package lk.ijse.hostelManagementSystem.Controller;/*
    @author Dasun
*/

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
    public JFXComboBox cmbRoomType;
    public JFXTextField txtQtq;


    public void btnAddRoomOnAction(ActionEvent actionEvent) {
        Session session = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
//       session.save();
        transaction.commit();
        session.close();
    }

    public void btnSaveRoomOnAction(ActionEvent actionEvent) {
    }

    public void cmbRoomTypeOnAction(ActionEvent actionEvent) {
    }

    public void btnSearchRoomOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateRoomOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }
}
