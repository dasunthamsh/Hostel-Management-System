package lk.ijse.hostelManagementSystem.util;/*
    @author Dasun
*/

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {

    public static AnchorPane pane;
    public static void navigate(Routes routes , AnchorPane pane) throws IOException {

        Navigation.pane=pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();


        switch (routes){
            case LOGIN:
                window.setTitle("Login Form");
                initUI("LoginForm.fxml");
                break;

            case DASHBORD:
                window.setTitle("Dashboard Form");
                initUI("DashboardForm.fxml");
                break;

            case STUDENT:
                window.setTitle("add student");
                initUI("ManageStudentForm.fxml");
                break;

            case REGESTER:
                window.setTitle("Regester user");
                initUI("RegesterUserForm.fxml");
                break;

            case FORGETPASSWORD:
                window.setTitle("Forget password");
                initUI("ForgetPasswordForm.fxml");
                break;

            case PAYMENT:
                window.setTitle("payment");
                initUI("PaymentDetails.fxml");
                break;

            default:
                new Alert(Alert.AlertType.ERROR,"Not Sutibale UI Found").show();
        }
    }

    private static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/ijse/hostelManagementSystem/view/"+location)));
    }

}
