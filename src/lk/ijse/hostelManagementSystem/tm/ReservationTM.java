package lk.ijse.hostelManagementSystem.tm;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.Entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationTM {

    private String resId;
    private LocalDate date;
    private Student student;
    public String status;
}
