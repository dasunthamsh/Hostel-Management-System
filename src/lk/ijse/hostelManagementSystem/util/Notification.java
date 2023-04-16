package lk.ijse.hostelManagementSystem.util;/*
    @author Dasun
*/

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Notification {

    public static  void showNotification(String url,String title,String text){
        Image image=new Image(url);
        Notification notifications=Notification.create();
        notifications .title(title);
        notifications  .text(text);
        notifications    .graphic(new ImageView(image));
        notifications  .hideAfter(Duration.seconds(3));
        notifications    .position(Pos.BOTTOM_RIGHT);
        notifications.darkStyle();
        notifications.show();
    }


}
