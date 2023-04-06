package lk.ijse.hostelManagementSystem.view.dtm;/*
    @author Dasun
*/


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTM {

    private String resId;
    private String status;
    private String room_Type_id;
    private String type;
    private String StudentId;
    private String name;
    private String payment;
}
