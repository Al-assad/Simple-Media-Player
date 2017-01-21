package simpleMediaPlayer;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

/**
 * create by Intellij IDEA
 * Author: Al-assad
 * E-mail: yulinying@1994.com
 * Github: https://github.com/Al-assad
 * Date: 2017/1/20 14:22
 * Description:    简易的多媒体播放器，以实现媒体控制栏，
 *    两种调用方式：PlayerController.Popup(String URL);  弹窗式窗口调用
 *                  PlayerController.newInstance(String URL),嵌入场景图式调用，返回一个Node类；
 *
 *    支持调用的音频格式：
 *          MP3；包含非压缩PCM的AIFF；
 *          包含非压缩PCM的WAV；
 *          使用AAC音频的MPEG-4;
 *
 *    支持调用的视频格式：
 *          包含VP6视频和MP3音频的FLV；
 *          使用H.264/AVC视频压缩的MPEG-4（MP4）
 */
public class SimpleMediaPlayer extends AnchorPane {

//TODO 修改player.fxml 使其为自适应的大小，使用AnchorBar或者修改底部工具栏高度


    private static SimpleMediaPlayer simpleMediaPlayer;   //创建实例保存到私有域中
    private PlayerController controller;     //储存每个实例的控制器对象


    protected PlayerController getController(){   //提供控制器对象的调用接口
        return this.controller;
    }


    //构造函数私有，实例保存在静态域，只向外部提供静态调用
    private SimpleMediaPlayer(String mediaUrl){
        try {
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("player.fxml"));
            Parent root = fxmlloader.load();   //将fxml节点添加到根节点中
            controller = fxmlloader.getController();
            this.getChildren().add(root);   //主类节点加入根节点


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //TODO setsSize失效
    //设置播放器大小:暂不支持 popup 产生的实例调用该方法
    public void setSize(int width,int height){
        if(simpleMediaPlayer.getController().getPopup())
            return ;
        simpleMediaPlayer.getController().setMediaPlayer(width,height);
    }

    //实例化调用:默认大小500*400
    public static SimpleMediaPlayer  newInstance(String mediaUrl){
        return newInstance(mediaUrl,600,400);
    }
    public static SimpleMediaPlayer newInstance(String mediaUrl,int width,int height){
        simpleMediaPlayer = new SimpleMediaPlayer(mediaUrl);
        simpleMediaPlayer.getController().start(mediaUrl,false,width,height);   //非窗口化启动播放器控件
        return simpleMediaPlayer;
    }

    //弹窗式调用：默认大小800*600
    public static SimpleMediaPlayer popup(String mediaUrl){
        return popup(mediaUrl,800,600);
    }
    public static SimpleMediaPlayer  popup(String mediaUrl,int width,int height){
       simpleMediaPlayer = new SimpleMediaPlayer(mediaUrl);
        simpleMediaPlayer.getController().start(mediaUrl,true,width,height);
        Scene scene = new Scene(simpleMediaPlayer,width,height);
        simpleMediaPlayer.getController().setScene(scene);

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Media Player");
        primaryStage.setScene(scene);

        //检测弹出窗口关闭事件，手动销毁simpleMediaPlayer对象；
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>(){
            @Override
            public void handle(WindowEvent event) {
                simpleMediaPlayer.getController().destroy();
            }
        });
        primaryStage.show();
        return simpleMediaPlayer;
    }







}
