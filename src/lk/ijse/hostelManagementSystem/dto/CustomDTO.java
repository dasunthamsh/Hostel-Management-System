package lk.ijse.hostelManagementSystem.dto;/*
    @author Dasun
*/

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@ToString
public class CustomDTO {

    private String resId;
    private String status;
    private String roomTpeId;
    private String studentId;
    private LocalDate date;


    public CustomDTO(String resId, String status, String roomTpeId, String studentId, LocalDate date) {
        this.resId = resId;
        this.status = status;
        this.roomTpeId = roomTpeId;
        this.studentId = studentId;
        this.date = date;
    }
}
