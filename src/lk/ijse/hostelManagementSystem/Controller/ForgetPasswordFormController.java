package lk.ijse.hostelManagementSystem.Controller;/*
    @author Dasun
*/

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostelManagementSystem.util.Navigation;
import lk.ijse.hostelManagementSystem.util.Routes;

import java.io.IOException;

public class ForgetPasswordFormController {
    public JFXButton btnReset;
    public JFXTextField txtPassword;
    public JFXButton btnBack;
    public AnchorPane pane;
    public JFXTextField txtId;

    public void btnResetOnAction(ActionEvent actionEvent) {
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN,pane);
    }
}
