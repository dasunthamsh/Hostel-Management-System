package lk.ijse.hostelManagementSystem.Controller;/*
    @author Dasun
*/

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import lk.ijse.hostelManagementSystem.util.Navigation;
import lk.ijse.hostelManagementSystem.util.Routes;

import java.io.IOException;

public class DashboardFormController {



    public JFXButton btnLogout;
    public JFXButton btnDashBoard;
    public JFXButton btnManageStudent;
    public JFXButton btnManageRoom;
    public JFXButton btnReserveRoom;
    public Pane contex;
    public AnchorPane pane;
    public JFXButton btnPayment;
    public Text txtStudentCount;


    public void studentCount(){

    }

    public void btnDashBoardOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.DASHBORD,pane);
    }

    public void btnManageStudentOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/hostelManagementSystem/view/ManageStudentForm");

    }

    public void btnManageRoomsOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/hostelManagementSystem/view/ManageRoomForm");
    }

    public void btnReserveRoomOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/hostelManagementSystem/view/ReserveRoomForm");
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN,pane);
    }



    public void btnPaymentOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/hostelManagementSystem/view/PaymentDetails");
    }

    public void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
        contex.getChildren().clear();
        contex.getChildren().add(node);
    }
}
