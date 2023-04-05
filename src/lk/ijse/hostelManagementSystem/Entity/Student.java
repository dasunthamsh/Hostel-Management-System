package lk.ijse.hostelManagementSystem.Entity;/*
    @author Dasun
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    private String studentId;
    private String name;
    private String address;
    private String contactNo;
    private LocalDate dob;
    private String gender;

//    public Student(String studentId, String name, String address, String contactNo, LocalDate dob, String gender) {
//        this.studentId = studentId;
//        this.name = name;
//        this.address = address;
//        this.contactNo = contactNo;
//        this.dob = dob;
//        this.gender = gender;
//    }

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<Reservation> resList = new ArrayList<>();


    public Student(String studentId, String name, String address, String contactNo, LocalDate dob, String gender) {

        this.studentId = studentId;
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
        this.dob = dob;
        this.gender = gender;
    }
}
