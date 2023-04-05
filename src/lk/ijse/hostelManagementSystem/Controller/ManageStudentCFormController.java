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
import lk.ijse.hostelManagementSystem.bo.custom.StudentBO;
import lk.ijse.hostelManagementSystem.bo.BOFactory;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;


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


        studentBO.saveStudent(new StudentDTO(txtStudentId.getText(),txtStudentName.getText(),txtStudentAddress.getText(),txtStudentNo.getText(),cmbBirthDay.getValue(), (String) cmbGender.getValue()));
        clearText();
    }

    public void btnUpdateStudentOnAction(ActionEvent actionEvent) {

        studentBO.updateStudent(new StudentDTO(txtStudentId.getText(),txtStudentName.getText(),txtStudentAddress.getText(),txtStudentNo.getText(),cmbBirthDay.getValue(), (String) cmbGender.getValue()));
        clearText();
    }

    public void btnSearchStudentOnAction(ActionEvent actionEvent) {

        StudentDTO student = studentBO.searcStudent(txtStudentId.getText());


        txtStudentId.setText(student.getStudentId());
        txtStudentName.setText(student.getName());
        txtStudentAddress.setText(student.getAddress());
        txtStudentNo.setText(student.getContactNo());
        cmbBirthDay.setValue(student.getDob());
        cmbGender.setValue(student.getGender());

    }

    public void btnDeleteStudentOnAction(ActionEvent actionEvent) {

        studentBO.deleteStudent(txtStudentId.getText());
        clearText();
    }

    public void cmbGenderOnAction() {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("Mail" , "Femail","other");
        cmbGender.setItems(list);
    }



    public void initialize() {
        cmbGenderOnAction();


    }

    public void clearText(){
        txtStudentId.setText("");
        txtStudentName.setText("");
        txtStudentAddress.setText("");
        txtStudentNo.setText("");
    }
}