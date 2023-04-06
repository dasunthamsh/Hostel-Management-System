package lk.ijse.hostelManagementSystem.Controller;/*
    @author Dasun
*/

import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hostelManagementSystem.bo.BOFactory;
import lk.ijse.hostelManagementSystem.bo.custom.PaymentBo;

import java.net.URL;
import java.util.ResourceBundle;

public class PaymentDetailsController {
    public TableColumn colStudentId;
    public TableColumn colStudentName;
    public TableColumn colRoomId;
    public TableColumn colRoomType;
    public TableColumn colStutas;
    public TableColumn colResevetionId;
    public TableView tlbpayment;


    private final PaymentBo paymentBo = (PaymentBo) BOFactory.getInstance().getBO(BOFactory.BOTypes.PAYMENT);

    public void initialize() {
        colResevetionId.setCellValueFactory(new PropertyValueFactory<>("resId"));
        colRoomType.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colRoomId.setCellValueFactory(new PropertyValueFactory<>("roomTpeId"));
        colRoomType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colStutas.setCellValueFactory(new PropertyValueFactory<>("status"));
    }


}
