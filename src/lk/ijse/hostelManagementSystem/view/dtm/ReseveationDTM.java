package lk.ijse.hostelManagementSystem.view.dtm;/*
    @author Dasun
*/

import com.jfoenix.controls.JFXButton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReseveationDTM {

    private String resId;
    private LocalDate date;
    private String studentId;
    private String status;
    private String roomTpeId;



    public ReseveationDTM(String resId, LocalDate date, String status, String roomTpeId, String studentId, JFXButton button) {

        this.resId = resId;
        this.date = date;
        this.studentId = studentId;
        this.status = status;
        this.roomTpeId = roomTpeId;
    }

    public ReseveationDTM(String resId, LocalDate date, String status, String roomTpeId) {
        this.resId = resId;
        this.date = date;
        this.studentId = studentId;
        this.status = status;
        this.roomTpeId = roomTpeId;
    }
}
