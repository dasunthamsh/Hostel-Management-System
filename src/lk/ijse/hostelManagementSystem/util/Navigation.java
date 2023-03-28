package lk.ijse.hostelManagementSystem.util;/*
    @author Dasun
*/

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Navigation {

    public static AnchorPane pane;
    public static void navigate(Routes routes , Anchorpane pane){

        Navigation.pane=pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();


        switch (routes){
            case Loging
        }
    }

}
