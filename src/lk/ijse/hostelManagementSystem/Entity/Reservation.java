package lk.ijse.hostelManagementSystem.Entity;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.dto.RoomDTO;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor

@Entity
public class Reservation {
    @Id
    private String resId;
    private LocalDate date;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentId",referencedColumnName = "studentId")
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roomTpeId",referencedColumnName = "roomTpeId")
    private Room room;
    public String status;


    public Reservation(String resId, LocalDate date, Student student, Room room, String status) {
        this.resId = resId;
        this.date = date;
        this.student = student;
        this.room = room;
        this.status = status;
    }
}
