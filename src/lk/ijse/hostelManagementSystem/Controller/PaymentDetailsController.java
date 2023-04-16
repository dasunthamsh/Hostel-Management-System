package lk.ijse.hostelManagementSystem.Controller;/*
    @author Dasun
*/

import com.jfoenix.controls.JFXButton;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.hostelManagementSystem.bo.BOFactory;
import lk.ijse.hostelManagementSystem.bo.custom.PaymentBo;
import lk.ijse.hostelManagementSystem.bo.custom.ReservationBO;
import lk.ijse.hostelManagementSystem.dto.CustomDTO;
import lk.ijse.hostelManagementSystem.util.Notification;
import lk.ijse.hostelManagementSystem.view.dtm.ReseveationDTM;
import tray.animations.AnimationType;
import tray.notification.NotificationType;

import java.util.List;

public class PaymentDetailsController {
    public TableColumn colStudentId;
    public TableColumn colRoomId;
    public TableColumn colStutas;
    public TableColumn colResevetionId;
    public TableView tlbpayment;
    public AnchorPane pain;
    public TableColumn colUpdate;
    public TableColumn colDate;
    public TableColumn colDelete;

    ReservationBO reservationBO = (ReservationBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.RESEVATION);

   private final PaymentBo paymentBo = (PaymentBo) BOFactory.getInstance().getBO(BOFactory.BOTypes.PAYMENT);
//
//
    public void initialize()  {
        loadAllPendingPayments();
        colResevetionId.setCellValueFactory(new PropertyValueFactory<>("resId"));
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colRoomId.setCellValueFactory(new PropertyValueFactory<>("roomTpeId"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colStutas.setCellValueFactory(new PropertyValueFactory<>("status"));
        colUpdate.setCellValueFactory(new PropertyValueFactory<>("Update"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("Delete"));

    }

    private void loadAllPendingPayments(){

        List<CustomDTO> pending = paymentBo.lodeReservation();
        for (CustomDTO dto : pending){
            tlbpayment.getItems().add(new ReseveationDTM(dto.getResId(), dto.getDate(), dto.getStatus(), dto.getRoomTpeId(), dto.getStudentId()));
        }

//        tlbpayment.setItems(FXCollections.observableArrayList(reservationBO.lodeReservation().stream().map(dto -> {
//            return new ReseveationDTM(dto.getResId(),dto.getDate(), dto.getStatus(), dto.getRoomTpeId(), dto.getStudentId(),getButton(dto.getResId()));
//        })));
    }

//
//    private void loadAllPendingPayments()  {
//        tlbpayment.setItems(FXCollections.observableArrayList(paymentBo.getPendingPayments().stream().map(dto -> {
//            return new PaymentDTM(dto.getResId(),dto.getStudentId(), dto.getName(), dto.getRoomTpeId(), dto.getType(), dto.getStatus(), getButton(dto.getResId()));
//        })));
//    }
//
    private JFXButton getButton(String resId){
        JFXButton btn = new JFXButton("pay");
        btn.setStyle("-fx-background-color: black");
        btn.setOnAction(event -> {
            if(new Alert(Alert.AlertType.CONFIRMATION,"Are You Shure?" , ButtonType.YES , ButtonType.NO).showAndWait().get().equals(ButtonType.YES)){
                if(reservationBO.updatePaymentStutes(resId)){
                    Notification.playNotification(AnimationType.POPUP,"Reservation Stutas Update Successfully", NotificationType.SUCCESS, Duration.millis(3000));
                }
            }
        });

        return btn;
    }



}
