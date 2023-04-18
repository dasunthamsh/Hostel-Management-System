package lk.ijse.hostelManagementSystem.dto;/*
    @author Dasun
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReservationDTO {

    private String resId;
    private LocalDate date;
  //  private String studentId;
   // private String roomTpeId;
    private StudentDTO student;
    private RoomDTO room;
    private String status;


    public ReservationDTO(String resId, LocalDate date, String status) {
        this.resId = resId;
        this.date = date;
        this.status = status;
    }
}
