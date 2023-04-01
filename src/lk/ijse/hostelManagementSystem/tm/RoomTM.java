package lk.ijse.hostelManagementSystem.tm;/*
    @author Dasun
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class RoomTM {

    private String roomTpeId;
    private String type;
    private String keyMoney;
    private int qyt;

}
