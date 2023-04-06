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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    public TableColumn colStuduentId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colDOB;
    public TableColumn colGender;
    public TableView tblStudent;

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

        colStuduentId.setCellValueFactory(new PropertyValueFactory<>("roomTpeId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("type"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("qyt"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("qyt"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("qyt"));

    }

    public void clearText(){
        txtStudentId.setText("");
        txtStudentName.setText("");
        txtStudentAddress.setText("");
        txtStudentNo.setText("");
    }
}