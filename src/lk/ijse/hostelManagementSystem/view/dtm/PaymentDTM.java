package lk.ijse.hostelManagementSystem.view.dtm;/*
    @author Dasun
*/


import com.jfoenix.controls.JFXButton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentDTM {

    private String resId;
    private String status;
    private String roomTpeId;
    private String studentId;
    private LocalDate date;
    private JFXButton btn;
}
