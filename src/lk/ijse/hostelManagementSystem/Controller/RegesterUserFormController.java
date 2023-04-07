package lk.ijse.hostelManagementSystem.Controller;/*
    @author Dasun
*/

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostelManagementSystem.util.Navigation;

public class RegesterUserFormController {

    public JFXTextField txtId;
    public JFXTextField txtEmail;
    public JFXTextField txtPassword;
    public JFXButton btnBack;
    public JFXButton btnRegester;
    public AnchorPane pain;

    public void btnBackOnAction(ActionEvent actionEvent) {
        Navigation.navigate();
    }

    public void btnRegesterOnAction(ActionEvent actionEvent) {
    }
}
