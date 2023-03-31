package lk.ijse.hostelManagementSystem.Controller;/*
    @author Dasun
*/

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;

import lk.ijse.hostelManagementSystem.Entity.Room;
import lk.ijse.hostelManagementSystem.bo.RoomBO;
import lk.ijse.hostelManagementSystem.bo.impl.custom.BOFactory;
import lk.ijse.hostelManagementSystem.dto.RoomDTO;
import lk.ijse.hostelManagementSystem.util.FactoryConfigeration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ManageRoomFormController {

    public JFXTextField txtRoomTypeID;
    public JFXTextField txtKeyMoney;
    public JFXComboBox cmbRoomType;
    public JFXTextField txtQtq;

    RoomBO roomBO = (RoomBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ROOM);

    public void btnAddRoomOnAction(ActionEvent actionEvent) {
        Session session = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
//       session.save();
        transaction.commit();
        session.close();
    }

    public void btnSaveRoomOnAction(ActionEvent actionEvent) {
        roomBO.saveRoom(new RoomDTO(txtRoomTypeID.getText(),cmbRoomType.getValue(),txtQtq.getText(),txtKeyMoney.getText()));
    }

    public void btnSearchRoomOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateRoomOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }

    public void cmbRoomTypeOnAction() {
    }
}
