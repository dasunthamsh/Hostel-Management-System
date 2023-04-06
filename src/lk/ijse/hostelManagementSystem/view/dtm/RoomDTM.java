package lk.ijse.hostelManagementSystem.view.dtm;/*
    @author Dasun
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class RoomDTM {

    private String roomTpeId;
    private String type;
    private String keyMoney;
    private int qyt;


    public RoomDTM(String roomTpeId, String type, int qyt , String keyMoney) {
        this.roomTpeId = roomTpeId;
        this.type = type;
        this.keyMoney = keyMoney;
        this.qyt = qyt;
    }
}
