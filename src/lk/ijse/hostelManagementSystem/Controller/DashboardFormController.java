package lk.ijse.hostelManagementSystem.Controller;/*
    @author Dasun
*/

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class DashboardFormController {



    public JFXButton btnLogout;
    public JFXButton btnDashBoard;
    public JFXButton btnManageStudent;
    public JFXButton btnManageRoom;
    public JFXButton btnReserveRoom;
    public Pane contex;
    public AnchorPane pane;

    public void btnDashBoardOnAction(ActionEvent actionEvent) {
    }

    public void btnManageStudentOnAction(ActionEvent actionEvent) {
    }

    public void btnManageRoomsOnAction(ActionEvent actionEvent) {
    }

    public void btnReserveRoomOnAction(ActionEvent actionEvent) {
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) {
    }

        public void setUi(String ui) throws IOException {
            Parent node = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
            contex.getChildren().clear();
            contex.getChildren().add(node);
        }
}
