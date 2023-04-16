package lk.ijse.hostelManagementSystem.view.dtm;/*
    @author Dasun
*/

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
    private String name;




    public ReseveationDTM(String studentId,String name,String roomTpeId , String status) {
        this.studentId = studentId;
        this.name = name;
        this.roomTpeId = roomTpeId;
        this.status = status;


    }
}
