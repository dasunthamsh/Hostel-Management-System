package lk.ijse.hostelManagementSystem.Controller;/*
    @author Dasun
*/

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hostelManagementSystem.bo.custom.RoomBO;
import lk.ijse.hostelManagementSystem.bo.BOFactory;
import lk.ijse.hostelManagementSystem.dto.RoomDTO;
import lk.ijse.hostelManagementSystem.util.FactoryConfigeration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ManageRoomFormController {

    public JFXTextField txtRoomTypeID;
    public JFXTextField txtKeyMoney;
    public JFXComboBox cmbRoomType;
    public JFXTextField txtQtq;
    public JFXButton btnSaveRoom;
    public TableView tblStudent;
    public TableColumn colRoomTypeId;
    public TableColumn cloRoomType;
    public TableColumn colKeyMoney;
    public TableColumn colQty;
    public JFXButton btnSerchRoom;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;

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
        roomBO.deleteRoom(txtRoomTypeID.getText());
    }

    public void cmbRoomTypeOnAction() {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("Non-AC ","Non-AC / Food","AC ","AC / Food");
        cmbRoomType.setItems(list);

    }



    public void initialize() {
        cmbRoomTypeOnAction();

        colRoomTypeId.setCellValueFactory(new PropertyValueFactory<>("roomTpeId"));
        cloRoomType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qyt"));


    }

    public void lodeRoomDta(){

    }
}
