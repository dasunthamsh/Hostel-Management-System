package lk.ijse.hostelManagementSystem.util;/*
    @author Dasun
*/

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.TextField;

import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class ValidationUtil {

        public static Object Validate(LinkedHashMap<JFXTextField, Pattern> RegexMap, JFXButton button) {
            for (TextField field : RegexMap.keySet()) {
                Pattern pattern = RegexMap.get(field);
                if (!pattern.matcher(field.getText()).matches()) {
                    addError(field, button);
                    return field;
                }
                removeError(field, button);
            }
            return true;
        }
    
        private static void removeError(TextField field, JFXButton button) {
            field.getParent().setStyle("-fx-border-color: green;"+"-fx-border-width:1;"+"-fx-border-radius:  5;"+"-fx-background-radius:  5;");
    
            button.setDisable(false);
        }
    
        private static void addError(TextField field, JFXButton button) {
            if (!field.getText().isEmpty()) {
                field.getParent().setStyle("-fx-border-color: red;"+"-fx-border-width:5;"+"-fx-border-radius:  5;"+"-fx-background-radius:  5;");
    
            }
            button.setDisable(true);
        }
}
