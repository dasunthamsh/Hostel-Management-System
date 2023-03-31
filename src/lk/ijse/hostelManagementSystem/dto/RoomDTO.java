package lk.ijse.hostelManagementSystem.dto;/*
    @author Dasun
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {

    private String roomTpeId;
    private String type;
    private String keyMoney;
    private int qyt;

    public RoomDTO(String roomTpeId, String type, int qyt , String keyMoney) {
        this.roomTpeId = roomTpeId;
        this.type = type;
        this.keyMoney = keyMoney;
        this.qyt = qyt;
    }
}
