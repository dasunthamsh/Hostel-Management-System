package lk.ijse.hostelManagementSystem.view.dtm;/*
    @author Dasun
*/


import com.jfoenix.controls.JFXButton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTM {

    private String resId;
    private String status;
    private String roomTpeId;
    private String type;
    private String studentId;
    private String name;
    private JFXButton btn;
}
