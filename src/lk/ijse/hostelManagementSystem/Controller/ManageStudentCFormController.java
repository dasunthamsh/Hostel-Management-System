package lk.ijse.hostelManagementSystem.Controller;/*
    @author Dasun
*/

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostelManagementSystem.bo.StudentBO;
import lk.ijse.hostelManagementSystem.bo.impl.custom.BOFactory;

public class ManageStudentCFormController {

    public JFXTextField txtStudentId;
    public JFXTextField txtStudentName;
    public JFXTextField txtStudentAddress;
    public JFXTextField txtStudentNo;
    public JFXDatePicker cmbBirthDay;
    public JFXComboBox cmbGender;
    public JFXButton btnAddStudent;
    public JFXButton btnUpdateStudent;
    public JFXButton btnSerchStudent;
    public JFXButton btnDeleteStudent;

    StudentBO studentBO = (StudentBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.STUDENT);

    String sId =txtStudentId.getText();
    String sName = txtStudentName.getText();
    String sAddress = txtStudentAddress.getText();
    String sNo = txtStudentNo.getText();
    String dob = String.valueOf(cmbBirthDay.getValue());
    String sGender = String.valueOf(cmbGender.getValue());


    public void btnAddStudentNoOnAction(ActionEvent actionEvent) {



    }

    public void btnUpdateStudentOnAction(ActionEvent actionEvent) {
    }

    public void btnSearchStudentOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteStudentOnAction(ActionEvent actionEvent) {
    }
}
