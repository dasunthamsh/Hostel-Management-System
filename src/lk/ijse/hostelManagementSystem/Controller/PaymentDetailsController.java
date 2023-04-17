package lk.ijse.hostelManagementSystem.Controller;/*
    @author Dasun
*/

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostelManagementSystem.bo.BOFactory;
import lk.ijse.hostelManagementSystem.bo.custom.PaymentBo;
import lk.ijse.hostelManagementSystem.dto.CustomDTO;
import lk.ijse.hostelManagementSystem.util.Notifications;

import java.util.List;

;

public class PaymentDetailsController {
    public TableColumn colStudentId;
    public TableColumn colRoomId;
    public TableView tlbpayment;
    public AnchorPane pain;
    public TableColumn colUpdate;
    public TableColumn colStudentName;
    public TableColumn colRoomType;
    public TableColumn colStatus;
    public TableColumn colResrvationID;


   private final PaymentBo paymentBo = (PaymentBo) BOFactory.getInstance().getBO(BOFactory.BOTypes.PAYMENT);

    public void initialize()  {
        loadtable();
    }

    private void loadtable(){

        List<Object[]> list=paymentBo.getPendingKeyPayments();
        ObservableList<CustomDTO> obList= FXCollections.observableArrayList();
        for (Object[] r: list) {

            obList.add(new CustomDTO(r[0].toString(),r[1].toString(),r[2].toString(),r[3].toString(),r[4].toString(),
                    r[5].toString(),getButton(r[0].toString())));
        }
        tlbpayment.setItems(obList);
        colResrvationID.setCellValueFactory(new PropertyValueFactory<>("resId"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colRoomType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colRoomId.setCellValueFactory(new PropertyValueFactory<>("roomTpeId"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colUpdate.setCellValueFactory(new PropertyValueFactory<>("btn"));



    }

    private JFXButton getButton(String resId){
        JFXButton btn = new JFXButton("pay");
        btn.setStyle("-fx-color: red");
        btn.setStyle("-fx-border-color: black");
        btn.setOnAction(event -> {
            boolean isUpdate = paymentBo.updatePayment(resId);
            if(isUpdate){
                String url ="lk/ijse/hostelManagementSystem/assets/notification.png";
                String title ="Succeccful";
                String text ="Paument updated";
                Notifications.showNotification(url , title , text);

            }else {
                String url = "lk/ijse/hostelManagementSystem/assets/sorry.png";
                String title = "UnSuccessful";
                String text = "payment Update UnSuccessful";
                Notifications.showNotification(url,title,text);
            }
        });

        return btn;

    }




}
