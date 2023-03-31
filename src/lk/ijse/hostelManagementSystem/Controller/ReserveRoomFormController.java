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
import javafx.scene.control.Label;
import lk.ijse.hostelManagementSystem.Entity.Reservation;
import lk.ijse.hostelManagementSystem.Entity.Student;
import lk.ijse.hostelManagementSystem.bo.ReservationBO;
import lk.ijse.hostelManagementSystem.bo.impl.custom.BOFactory;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ReserveRoomFormController {
    public JFXComboBox cmbStudentId;
    public JFXComboBox cmbRoomId;
    public JFXButton btnReservRoom;
    public JFXTextField txtStudentName;
    public JFXTextField txtroomType;
    public JFXTextField txtAvalableQyt;
    public JFXTextField txtMoney;
    public JFXComboBox cmbPayment;
    public Label lblTime;
    public Label lblReserveId;

    ReservationBO reservationBO = (ReservationBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.RESEVATION);

    public void btnReservRoomOnAction(ActionEvent actionEvent) {

    }


    public void initialize() {
        cmbPaymentOnAction();
    }

    public void cbmStudentIdOnAction() {

        cmbStudentId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue !=null){
                setStudentId(reservationBO.getStudentId(newValue));
            }
        });
    }




    private void setStudentId(StudentDTO student){txtStudentName.setText(student.getName());}

    public void cmbRoomIdTypeOnAction() {
    }

    public void cmbPaymentOnAction() {

        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("Payed","Pending");
        cmbPayment.setItems(list);
    }


}
