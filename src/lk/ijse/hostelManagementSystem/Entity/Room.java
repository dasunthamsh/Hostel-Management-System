package lk.ijse.hostelManagementSystem.Entity;/*
    @author Dasun
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Room {

    private String room_TpeId;
    private String type;
    private String key_Money;
    private int qyt;

}
