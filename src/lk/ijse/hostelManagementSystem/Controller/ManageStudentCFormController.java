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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import lk.ijse.hostelManagementSystem.bo.BOFactory;
import lk.ijse.hostelManagementSystem.bo.custom.StudentBO;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;
import lk.ijse.hostelManagementSystem.util.ValidationUtil;
import lk.ijse.hostelManagementSystem.view.dtm.StudentDTM;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;


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
    private final LinkedHashMap<JFXTextField, Pattern> RegexMap = new LinkedHashMap<>();




     public  void btnAddStudentNoOnAction(ActionEvent actionEvent) {


            studentBO.saveStudent(new StudentDTO(txtStudentId.getText(), txtStudentName.getText(), txtStudentAddress.getText(), txtStudentNo.getText(), cmbBirthDay.getValue(), (String) cmbGender.getValue()));


      //  clearText();
    }

    public void btnUpdateStudentOnAction(ActionEvent actionEvent) {

             studentBO.updateStudent(new StudentDTO(txtStudentId.getText(), txtStudentName.getText(), txtStudentAddress.getText(), txtStudentNo.getText(), cmbBirthDay.getValue(), (String) cmbGender.getValue()));

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
        selectAllStudents();
        colStuduentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));

        RegexMap.put(txtStudentId,Pattern.compile("^[S 0-9-]+$"));
        RegexMap.put(txtStudentName,Pattern.compile("^[A-z ]+$"));
        RegexMap.put(txtStudentAddress,Pattern.compile("^[A-z1-9 /,.-]+$"));
        RegexMap.put(txtStudentNo,Pattern.compile("^[0-9]{10,11}$"));

    }

    private void selectAllStudents(){
        ObservableList<StudentDTM> students = studentBO.getStudents();
        tblStudent.setItems(students);
    }


    public void validateFieldsOnKeyRelease(KeyEvent keyEvent) {
        Object validate = ValidationUtil.Validate(RegexMap, btnAddStudent);
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            if (validate instanceof JFXTextField) {
                ((JFXTextField) validate).requestFocus();
            } else {
                btnAddStudent.fire();
            }
        }
    }

    public void clearText(){
        txtStudentId.setText("");
        txtStudentName.setText("");
        txtStudentAddress.setText("");
        txtStudentNo.setText("");
    }

}