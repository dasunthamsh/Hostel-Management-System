package lk.ijse.hostelManagementSystem.Entity;/*
    @author Dasun
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation {
    @Id
    private String resId;
    private Date date;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentId",referencedColumnName = "studentId")
    private String studentId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "")
    private String roomTypeId;
    public String status;
}
