package lk.ijse.hostelManagementSystem.Controller;/*
    @author Dasun
*/

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostelManagementSystem.util.Navigation;
import lk.ijse.hostelManagementSystem.util.Routes;

import java.io.IOException;

public class LoginFormController {
    public JFXTextField txtEmail;
    public JFXPasswordField txtPassword;
    public JFXButton btnSignIn;
    public JFXButton btnCreateAccount;
    public JFXButton btnForgetPassword;
    public AnchorPane pane;

    public void btnSignOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.DASHBORD,pane);


    }

    public void btnCreateAccountOnAction(ActionEvent actionEvent) {
    }

    public void btnForgetPasswordOnAction(ActionEvent actionEvent) {
    }
}
