package lk.ijse.hostelManagementSystem.Controller;/*
    @author Dasun
*/

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.ijse.hostelManagementSystem.bo.custom.ReservationBO;
import lk.ijse.hostelManagementSystem.bo.custom.StudentBO;
import lk.ijse.hostelManagementSystem.bo.BOFactory;
import lk.ijse.hostelManagementSystem.dto.ReservationDTO;
import lk.ijse.hostelManagementSystem.dto.RoomDTO;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;

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
    public TextField txtResId;
    public JFXDatePicker cmbDate;

    ReservationBO reservationBO = (ReservationBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.RESEVATION);
    StudentBO studentBO = (StudentBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.STUDENT);



    public void btnReservRoomOnAction(ActionEvent actionEvent) {
        System.out.println(reservationBO.getResevationId());

        System.out.println(reservationBO.serchStudent(String.valueOf(cmbStudentId.getValue())));
        System.out.println(cmbStudentId.getValue());
        reservationBO.saveReservation(new ReservationDTO(reservationBO.getResevationId(),cmbDate.getValue(), reservationBO.serchStudent(String.valueOf(cmbStudentId.getValue())) ,reservationBO.serchRoom(String.valueOf(cmbRoomId.getValue())) ,(String) cmbPayment.getValue()));

        clearText();
    }


    public void initialize() {
        cmbPaymentOnAction();
        getResevationId();

        cmbRoomId.getItems().addAll(reservationBO.getRoomIds());
        cmbStudentId.getItems().addAll(reservationBO.getStudentIds());

        cmbStudentId.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue) -> {setStudentFields(reservationBO.serchStudent(String.valueOf(newValue)));});

        cmbRoomId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {setRoomFields(reservationBO.serchRoom(String.valueOf(newValue)));});
    }

    private void setStudentFields(StudentDTO student){txtStudentName.setText(student.getName());}

    private void setRoomFields(RoomDTO room){
        txtroomType.setText(room.getType());
        txtAvalableQyt.setText(String.valueOf(room.getQyt()));
        txtMoney.setText(room.getKeyMoney());
    }

    public void cmbRoomIdTypeOnAction() {
        cmbRoomId.getItems().addAll(reservationBO.getRoomIds());

    }

    public void cmbPaymentOnAction() {

        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("Payed","Pending");
        cmbPayment.setItems(list);
    }


    public void cbmStudentIdOnAction(ActionEvent actionEvent) {
        cmbStudentId.getItems().addAll(reservationBO.getStudentIds());
    }

    public void getResevationId(){
        lblReserveId.setText(reservationBO.getResevationId());
    }

    public void clearText(){
        cmbRoomId.setValue("");
        txtroomType.setText("");
        txtAvalableQyt.setText("");
        txtMoney.setText("");
        cmbStudentId.setValue("");
        txtStudentName.setText("");
        cmbPayment.setValue("");
    }
}
