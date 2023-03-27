package lk.ijse.hostelManagementSystem;/*
    @author Dasun
*/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class appInitilizer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource(""))));
    }
}
