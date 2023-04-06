package lk.ijse.hostelManagementSystem.Controller;/*
    @author Dasun
*/

import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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


    public void initialize() {
        colResevetionId.setCellValueFactory(new PropertyValueFactory<>("resId"));
        colRoomType.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colRoomId.setCellValueFactory(new PropertyValueFactory<>("roomTpeId"));
        colRoomType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colStutas.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    private void lodeAllValues(){
        tlbpayment.setItems(FXCollections.observableArrayList());
    }
}
