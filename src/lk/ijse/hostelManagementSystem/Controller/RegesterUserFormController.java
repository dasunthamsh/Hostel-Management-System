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
import lk.ijse.hostelManagementSystem.util.Routes;

import java.io.IOException;

public class RegesterUserFormController {

    public JFXTextField txtId;
    public JFXTextField txtEmail;
    public JFXTextField txtPassword;
    public JFXButton btnBack;
    public JFXButton btnRegester;
    public AnchorPane pain;
    public JFXTextField txtName;

    RegesterBO regesterBO = (RegesterBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.REGESTER);

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {

        Navigation.navigate(Routes.LOGIN,pain);
    }

    public void btnRegesterOnAction(ActionEvent actionEvent) throws IOException {

        regesterBO.saveUser(new RegesterDTO(txtId.getText(),txtName.getText(),txtEmail.getText(),txtPassword.getText()));

    }
}
