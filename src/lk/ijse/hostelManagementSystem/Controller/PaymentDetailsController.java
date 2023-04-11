package lk.ijse.hostelManagementSystem.Controller;/*
    @author Dasun
*/

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.hostelManagementSystem.bo.BOFactory;
import lk.ijse.hostelManagementSystem.bo.custom.PaymentBo;
import lk.ijse.hostelManagementSystem.util.Notification;
import lk.ijse.hostelManagementSystem.view.dtm.PaymentDTM;
import tray.animations.AnimationType;
import tray.notification.NotificationType;

public class PaymentDetailsController {
    public TableColumn colStudentId;
    public TableColumn colStudentName;
    public TableColumn colRoomId;
    public TableColumn colRoomType;
    public TableColumn colStutas;
    public TableColumn colResevetionId;
    public TableView tlbpayment;
    public AnchorPane pain;
    public TableColumn colUpdate;

    private final PaymentBo paymentBo = (PaymentBo) BOFactory.getInstance().getBO(BOFactory.BOTypes.PAYMENT);


    public void initialize() {
        loadAllPendingPayments();
        colResevetionId.setCellValueFactory(new PropertyValueFactory<>("resId"));
        colRoomType.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colRoomId.setCellValueFactory(new PropertyValueFactory<>("roomTpeId"));
        colRoomType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colStutas.setCellValueFactory(new PropertyValueFactory<>("status"));
        colStutas.setCellValueFactory(new PropertyValueFactory<>("btn"));
    }

    private void loadAllPendingPayments(){
        tlbpayment.setItems(FXCollections.observableArrayList(paymentBo.getPendingPayments().stream().map(dto -> {
            return new PaymentDTM(dto.getResId(),dto.getStudentId(), dto.getName(), dto.getRoomTpeId(), dto.getType(), dto.getStatus(), getButton(dto.getResId()));
        })));
    }

    private JFXButton getButton(String resId){
        JFXButton btn = new JFXButton("pay");
        btn.setStyle("-fx-background-color: black");
        btn.setOnAction(event -> {
            if(new Alert(Alert.AlertType.CONFIRMATION,"Are You Shure?" , ButtonType.YES , ButtonType.NO).showAndWait().get().equals(ButtonType.YES)){
                if(paymentBo.updatePaymentStutes(resId)){
                    Notification.playNotification(AnimationType.POPUP,"Reservation Stutas Update Successfully", NotificationType.SUCCESS, Duration.millis(3000));
                }
            }
        });

        return btn;
    }



}
