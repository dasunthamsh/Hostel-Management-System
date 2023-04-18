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
import lk.ijse.hostelManagementSystem.util.Notifications;
import lk.ijse.hostelManagementSystem.util.Routes;
import lk.ijse.hostelManagementSystem.util.ValidationUtil;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class RegesterUserFormController  {

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
        boolean isAdded =    regesterBO.saveUser(new RegesterDTO(txtId.getText(), txtName.getText(), txtEmail.getText(), txtPassword.getText()));
            if(isAdded){
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
                clearText();
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


    public void initialize() {
        RegexMap.put(txtId,Pattern.compile("^[C 0-9-]+$"));
        RegexMap.put(txtName,Pattern.compile("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$"));
        RegexMap.put(txtEmail,Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"));


    }

    public void clearText(){
        txtId.setText("");
        txtName.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
    }

    public void toName(ActionEvent actionEvent) {txtName.requestFocus(); }

    public void toEmali(ActionEvent actionEvent) { txtEmail.requestFocus();}

    public void toPassword(ActionEvent actionEvent) {txtPassword.requestFocus(); }

    public void toBtnRegester(ActionEvent actionEvent) {btnRegester.requestFocus(); }
}
