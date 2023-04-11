package lk.ijse.hostelManagementSystem.Controller;/*
    @author Dasun
*/

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostelManagementSystem.bo.BOFactory;
import lk.ijse.hostelManagementSystem.bo.custom.PaymentBo;

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
        colResevetionId.setCellValueFactory(new PropertyValueFactory<>("resId"));
        colRoomType.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colRoomId.setCellValueFactory(new PropertyValueFactory<>("roomTpeId"));
        colRoomType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colStutas.setCellValueFactory(new PropertyValueFactory<>("status"));
        colStutas.setCellValueFactory(new PropertyValueFactory<>("btn"));
    }



}
