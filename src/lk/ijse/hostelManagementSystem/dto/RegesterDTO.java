package lk.ijse.hostelManagementSystem.dto;/*
    @author Dasun
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegesterDTO {

    private String id;
    private String name;
    private String email;
    private String password;


    public RegesterDTO(String id, String password) {
        this.id = id;
        this.password = password;
    }
}
