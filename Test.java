package testSample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import simpleMediaPlayer.SimpleMediaPlayer;

/** 测试文件
* */
public class Test extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //创建测试窗口
        primaryStage.setTitle("Test Meida");
        Group root = new Group();
        BorderPane pane = new BorderPane();

        root.getChildren().add(pane);
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        pane.setBottom(hbox);
        Button popup = new Button("Popup");
        Button popup2 = new Button("Popup small");
        hbox.getChildren().addAll(popup,popup2);


        //测试嵌入式调用
        SimpleMediaPlayer player = SimpleMediaPlayer.newInstance(getClass().getResource("TestMedia.MP4").toString());
        pane.setCenter(player);
        pane.setAlignment(player,Pos.CENTER);


        //测试弹窗式调用
        popup.setOnAction((ActionEvent e)->{
            SimpleMediaPlayer.popup(getClass().getResource("TestMedia.MP4").toString());
        });
        popup2.setOnAction((ActionEvent e)->{
            SimpleMediaPlayer.popup(getClass().getResource("TestMedia.MP4").toString(),550,400);
        });


        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
