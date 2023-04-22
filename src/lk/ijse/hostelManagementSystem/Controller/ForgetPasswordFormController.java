package lk.ijse.hostelManagementSystem.Controller;/*
    @author Dasun
*/

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostelManagementSystem.bo.BOFactory;
import lk.ijse.hostelManagementSystem.bo.custom.RegesterBO;
import lk.ijse.hostelManagementSystem.dto.RegesterDTO;
import lk.ijse.hostelManagementSystem.util.Navigation;
import lk.ijse.hostelManagementSystem.util.Notifications;
import lk.ijse.hostelManagementSystem.util.Routes;

import java.io.IOException;

public class ForgetPasswordFormController {

RegesterBO regesterBO = (RegesterBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.REGESTER);

    public JFXButton btnReset;
    public JFXTextField txtPassword;
    public JFXButton btnBack;
    public AnchorPane pane;
    public JFXTextField txtId;

    public boolean btnResetOnAction(ActionEvent actionEvent) {
        boolean isUpdated = false;
        try {
            isUpdated = regesterBO.updateUser(new RegesterDTO(txtId.getText(),txtPassword.getText()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(isUpdated){
            if(isUpdated){
                String url ="lk/ijse/hostelManagementSystem/assets/notification.png" ;
                String titel = "Successful";
                String text = "Student is Added";
                Notifications.showNotification(url,text,titel);
            }else {
                String url ="lk/ijse/hostelManagementSystem/assets/notification.png" ;
                String titel = "error";
                String text = "Somthing was wrong";
                Notifications.showNotification(url,text,titel);
            }
        }
        return true;
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN,pane);
    }
}
