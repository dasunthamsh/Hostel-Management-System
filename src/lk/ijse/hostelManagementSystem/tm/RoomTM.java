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


    public RoomTM(String roomTpeId, String type, int qyt , String keyMoney) {
        this.roomTpeId = roomTpeId;
        this.type = type;
        this.keyMoney = keyMoney;
        this.qyt = qyt;
    }

}
