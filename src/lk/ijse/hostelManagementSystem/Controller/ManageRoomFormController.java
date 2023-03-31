package lk.ijse.hostelManagementSystem.Controller;/*
    @author Dasun
*/

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.Initializable;
import lk.ijse.hostelManagementSystem.Entity.Room;
import lk.ijse.hostelManagementSystem.bo.RoomBO;
import lk.ijse.hostelManagementSystem.bo.impl.custom.BOFactory;
import lk.ijse.hostelManagementSystem.dto.RoomDTO;
import lk.ijse.hostelManagementSystem.util.FactoryConfigeration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.net.URL;
import java.util.ResourceBundle;

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
        roomBO.saveRoom(new RoomDTO(txtRoomTypeID.getText(),(String) cmbRoomType.getValue(), Integer.parseInt(txtQtq.getText()),txtKeyMoney.getText()));
    }

    public void btnSearchRoomOnAction(ActionEvent actionEvent) {
        RoomDTO room =roomBO.searcRoom(txtRoomTypeID.getText());

        txtRoomTypeID.setText(room.getRoomTpeId());
        cmbRoomType.setValue(room.getType());
        txtQtq.setText(String.valueOf(room.getQyt()));
        txtKeyMoney.setText(room.getKeyMoney());

    }

    public void btnUpdateRoomOnAction(ActionEvent actionEvent) {
        roomBO.updateRoom(new RoomDTO(txtRoomTypeID.getText(),(String) cmbRoomType.getValue(), Integer.parseInt(txtQtq.getText()),txtKeyMoney.getText()));
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }

    public void cmbRoomTypeOnAction() {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("Non-AC ","Non-AC / Food","AC ","AC / Food");
        cmbRoomType.setItems(list);

    }



    public void initialize() {
        cmbRoomTypeOnAction();
    }
}
