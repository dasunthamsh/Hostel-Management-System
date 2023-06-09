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
import lk.ijse.hostelManagementSystem.util.Notifications;
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


         boolean isAdded = false;
         try {
             isAdded = studentBO.saveStudent(new StudentDTO(txtStudentId.getText(), txtStudentName.getText(), txtStudentAddress.getText(), txtStudentNo.getText(), cmbBirthDay.getValue(), (String) cmbGender.getValue()));
         } catch (Exception e) {
             e.printStackTrace();
         }
         if(isAdded){
             String url ="lk/ijse/hostelManagementSystem/assets/notification.png" ;
             String titel = "Successful";
             String text = "Student is Added";
             Notifications.showNotification(url,text,titel);
         }else {
             String url ="lk/ijse/hostelManagementSystem/assets/sorry.png" ;
             String titel = "error";
             String text = "Somthing was wrong";
             Notifications.showNotification(url,text,titel);
         }

        clearText();
    }

    public void btnUpdateStudentOnAction(ActionEvent actionEvent) {

        boolean isUpdated = false;
        try {
            isUpdated = studentBO.updateStudent(new StudentDTO(txtStudentId.getText(), txtStudentName.getText(), txtStudentAddress.getText(), txtStudentNo.getText(), cmbBirthDay.getValue(), (String) cmbGender.getValue()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(isUpdated){

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

    public void btnSearchStudentOnAction(ActionEvent actionEvent) {

        StudentDTO student = null;
        try {
            student = studentBO.searcStudent(txtStudentId.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }


        txtStudentId.setText(student.getStudentId());
        txtStudentName.setText(student.getName());
        txtStudentAddress.setText(student.getAddress());
        txtStudentNo.setText(student.getContactNo());
        cmbBirthDay.setValue(student.getDob());
        cmbGender.setValue(student.getGender());

    }

    public boolean btnDeleteStudentOnAction(ActionEvent actionEvent) {

        boolean isDeleted = false;
        try {
            isDeleted = studentBO.deleteStudent(txtStudentId.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isDeleted){
            String url ="lk/ijse/hostelManagementSystem/assets/notification.png" ;
            String titel = "Successful";
            String text = "Student is Added";
            Notifications.showNotification(url,text,titel);
        }else {
            String url ="lk/ijse/hostelManagementSystem/assets/sorry.png" ;
            String titel = "error";
            String text = "Somthing was wrong";
            Notifications.showNotification(url,text,titel);
        }

        return true;

    }

    public void cmbGenderOnAction() {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("Male" , "Female","other");
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

    public void toName(ActionEvent actionEvent) { txtStudentName.requestFocus();}

    public void toAddress(ActionEvent actionEvent) { txtStudentAddress.requestFocus();}

    public void toContact(ActionEvent actionEvent) { txtStudentNo.requestFocus();}

    public void toBirthaday(ActionEvent actionEvent) { cmbBirthDay.requestFocus();}

    public void toGender(ActionEvent actionEvent) { }
}