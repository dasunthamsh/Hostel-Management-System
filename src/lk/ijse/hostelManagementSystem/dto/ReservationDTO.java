package lk.ijse.hostelManagementSystem.dto;/*
    @author Dasun
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {

    private String resId;
    private LocalDate date;
    private StudentDTO student;
    private RoomDTO room;
    private String status;


    public ReservationDTO(String resId, LocalDate date, StudentDTO student, RoomDTO room, String status) {
        this.resId = resId;
        this.date = date;
        this.student = student;
        this.room = room;
        this.status = status;
    }
}
