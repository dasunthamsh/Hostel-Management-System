package lk.ijse.hostelManagementSystem.Entity;/*
    @author Dasun
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation {
    @Id
    private String resId;
    private Date date;
    private String studentId;
    private String roomTypeId;
    public String status;
}
