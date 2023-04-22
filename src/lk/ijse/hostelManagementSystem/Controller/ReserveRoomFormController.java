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
import lk.ijse.hostelManagementSystem.bo.BOFactory;
import lk.ijse.hostelManagementSystem.bo.custom.ReservationBO;
import lk.ijse.hostelManagementSystem.dto.ReservationDTO;
import lk.ijse.hostelManagementSystem.dto.RoomDTO;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;
import lk.ijse.hostelManagementSystem.util.Notifications;

import java.time.LocalDate;

public class ReserveRoomFormController {
    public JFXComboBox cmbStudentId;
    public JFXComboBox cmbRoomId;
    public JFXButton btnReservRoom;
    public JFXTextField txtStudentName;
    public JFXTextField txtroomType;
    public JFXTextField txtAvalableQyt;
    public JFXTextField txtMoney;
    public JFXComboBox cmbPayment;
    public Label lblReserveId;
    public TextField txtResId;
    public JFXDatePicker cmbDate;
    public JFXButton btnDelete;

    ReservationBO reservationBO = (ReservationBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.RESEVATION);




    public void btnReservRoomOnAction(ActionEvent actionEvent) {


        boolean isAdded = false;
        try {
            isAdded = reservationBO.saveReservation(new ReservationDTO(reservationBO.getResevationId(),cmbDate.getValue(), reservationBO.serchStudent(String.valueOf(cmbStudentId.getValue())) ,reservationBO.serchRoom(String.valueOf(cmbRoomId.getValue())) ,(String) cmbPayment.getValue()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(isAdded){
            String url ="lk/ijse/hostelManagementSystem/assets/notification.png" ;
            String titel = "Successful";
            String text = "Student is Added";
            Notifications.showNotification(url,text,titel);
        }else {
            String url ="lk/ijse/hostelManagementSystem/assets/sorry.png" ;
            String titel = "error";
            String text = "Somthing was wrong";
            Notifications.showNotification(url,text,titel);
        }
    }



    public void btnDeleteOnAction(ActionEvent actionEvent) {
        reservationBO.deleteReservation(txtResId.getText());
    }


    public void initialize() {
        LocalDate date = LocalDate.now();
        cmbDate.setValue(LocalDate.parse(String.valueOf(date)));
        //setTime();
        cmbPaymentOnAction();
        getResevationId();

        cmbRoomId.getItems().addAll(reservationBO.getRoomIds());
        cmbStudentId.getItems().addAll(reservationBO.getStudentIds());

       cmbStudentId.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue) -> {
           try {
               setStudentFields(reservationBO.serchStudent(String.valueOf(newValue)));
           } catch (Exception e) {
               e.printStackTrace();
           }
       });

        cmbRoomId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                setRoomFields(reservationBO.serchRoom(String.valueOf(newValue)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
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
        txtResId.setText(reservationBO.getResevationId());
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
