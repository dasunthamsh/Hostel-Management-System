package lk.ijse.hostelManagementSystem.Controller;/*
    @author Dasun
*/

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import lk.ijse.hostelManagementSystem.bo.StudentBO;
import lk.ijse.hostelManagementSystem.bo.impl.custom.BOFactory;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;

import java.time.LocalDate;
import java.util.Date;


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




    public void btnAddStudentNoOnAction(ActionEvent actionEvent) {

        String sId =txtStudentId.getText();
        String sName = txtStudentName.getText();
        String sAddress = txtStudentAddress.getText();
        String sNo = txtStudentNo.getText();
        String dob = String.valueOf(cmbBirthDay.getValue());
        String sGender = String.valueOf(cmbGender.getValue());

        studentBO.saveStudent(new StudentDTO(txtStudentId.getText(),txtStudentName.getText(),txtStudentAddress.getText(),txtStudentNo.getText(),cmbBirthDay.getValue(), (String) cmbGender.getValue()));


    }

    public void btnUpdateStudentOnAction(ActionEvent actionEvent) {
    }

    public void btnSearchStudentOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteStudentOnAction(ActionEvent actionEvent) {
    }

    public void cmbGenderOnAction(ActionEvent actionEvent) {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("Mail" , "Femail","පොන්නයො");
        cmbGender.setItems(list);
    }
}
