package lk.ijse.hostelManagementSystem.Controller;/*
    @author Dasun
*/

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostelManagementSystem.bo.BOFactory;
import lk.ijse.hostelManagementSystem.bo.custom.RegesterBO;
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

    RegesterBO regesterBO = (RegesterBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.REGESTER);

    public void btnSignOnAction(ActionEvent actionEvent) throws IOException {

        if(regesterBO.checkPassword(txtEmail.getText(),txtPassword.getText())){

            Navigation.navigate(Routes.DASHBORD,pane);
        }


    }

    public void btnCreateAccountOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.REGESTER,pane);
    }

    public void btnForgetPasswordOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.FORGETPASSWORD,pane);
    }

    public void toPassword(ActionEvent actionEvent) { txtPassword.requestFocus();}

    public void toBtnSignin(ActionEvent actionEvent) { btnSignIn.requestFocus();}
}
