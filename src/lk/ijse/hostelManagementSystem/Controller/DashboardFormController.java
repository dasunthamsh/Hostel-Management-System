package lk.ijse.hostelManagementSystem.Controller;/*
    @author Dasun
*/

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import lk.ijse.hostelManagementSystem.bo.BOFactory;
import lk.ijse.hostelManagementSystem.bo.custom.StudentBO;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;
import lk.ijse.hostelManagementSystem.util.Navigation;
import lk.ijse.hostelManagementSystem.util.Routes;

import java.io.IOException;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class DashboardFormController  {



    public JFXButton btnLogout;
    public JFXButton btnDashBoard;
    public JFXButton btnManageStudent;
    public JFXButton btnManageRoom;
    public JFXButton btnReserveRoom;
    public Pane contex;
    public AnchorPane pane;
    public JFXButton btnPayment;
    public Text txtStudentCount;
    public LineChart lineChrtStusentJoin;
    public Text txtDate;
    public Text txtTime;


    StudentBO studentBO = (StudentBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.STUDENT);



    public void studentCount(){
        List<StudentDTO> dtos = studentBO.getAllStudents();

        txtStudentCount.setText(String.format("%02d",dtos.size()));
    }


    public void studentJoinStatus(){
        lineChrtStusentJoin.setTitle("Student Join Rate");

        XYChart.Series thisYear = new XYChart.Series();
        XYChart.Series lastYear = new XYChart.Series();

        thisYear.setName("This Year Data");
        lastYear.setName("Last Year Data");

        String[] month ={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};

        for (int i=1 ; i<12 ; i++){
            BigInteger bigInteger =(studentBO.getStudentJoinCount(String.format("%d-%02d", LocalDate.now().getYear(),i)+"%"));
            thisYear.getData().add(new XYChart.Data<>(month[i-1],bigInteger));
        }
        lineChrtStusentJoin.getData().add(thisYear);
        lineChrtStusentJoin.getData().add(lastYear);
    }


    private void setTime() {
        Thread clock = new Thread() {
            public void run() {
                while (true) {
                    DateFormat hour = new SimpleDateFormat("hh:mm:ss");
                    txtTime.setText(hour.format(new Date()));

                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        };
        clock.start();
    }

    public void btnDashBoardOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.DASHBORD,pane);
    }

    public void btnManageStudentOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/hostelManagementSystem/view/ManageStudentForm");

    }

    public void btnManageRoomsOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/hostelManagementSystem/view/ManageRoomForm");
    }

    public void btnReserveRoomOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/hostelManagementSystem/view/ReserveRoomForm");
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN,pane);
    }



    public void btnPaymentOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/hostelManagementSystem/view/PaymentDetails");
    }

    public void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
        contex.getChildren().clear();
        contex.getChildren().add(node);
    }


    public void initialize() {
        LocalDate date = LocalDate.now();
        txtDate.setText(String.valueOf(date));
        setTime();
        studentCount();
        studentJoinStatus();
    }
}
