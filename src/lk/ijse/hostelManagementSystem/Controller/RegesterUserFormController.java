package lk.ijse.hostelManagementSystem.Controller;/*
    @author Dasun
*/

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostelManagementSystem.bo.BOFactory;
import lk.ijse.hostelManagementSystem.bo.custom.RegesterBO;
import lk.ijse.hostelManagementSystem.dto.RegesterDTO;
import lk.ijse.hostelManagementSystem.util.Navigation;
import lk.ijse.hostelManagementSystem.util.Routes;
import lk.ijse.hostelManagementSystem.util.ValidationUtil;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class RegesterUserFormController {

    public JFXTextField txtId;
    public JFXTextField txtEmail;
    public JFXTextField txtPassword;
    public JFXButton btnBack;
    public JFXButton btnRegester;
    public AnchorPane pain;
    public JFXTextField txtName;

    RegesterBO regesterBO = (RegesterBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.REGESTER);
    private final LinkedHashMap<JFXTextField, Pattern> RegexMap = new LinkedHashMap<>();


    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {

        Navigation.navigate(Routes.LOGIN,pain);
    }

    public void btnRegesterOnAction(ActionEvent actionEvent) throws IOException {

            regesterBO.saveUser(new RegesterDTO(txtId.getText(), txtName.getText(), txtEmail.getText(), txtPassword.getText()));
    }

    public void validateFieldsOnKeyRelease(KeyEvent keyEvent) {
        Object validate = ValidationUtil.Validate(RegexMap, btnRegester);
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            if (validate instanceof JFXTextField) {
                ((JFXTextField) validate).requestFocus();
            } else {
                btnRegester.fire();
            }
        }
    }
}
