## SimpleMediaPlayer  
### JavaFX内嵌多媒体播放器  
  
  
 <img src="https://github.com/Al-assad/Simple-Media-Player/blob/master/sample.PNG" width="500" height="auto">

### 环境和功能说明
使用JavaFX MediaPlayer作为内核开发，提供完整的多媒体播放控制栏和全屏播放功能；  
作为JavaFX内嵌节点使用，使用JavaFX 8版本；
主要提供的视频操作功能：
* 开始/暂停/停止播放；
* 音量控制；
* 进度条控制；
* 全屏；
* 弹出窗口播放；


### 支持的多媒体格式
**音频**  
* MP3；  
* 包含非压缩PCM的AIFF；  
* 包含非压缩PCM的WAV；  
* 使用AAC音频的MPEG-4;  
**视频**  
* 包含VP6视频和MP3音频的FLV；  
* 使用H.264/AVC视频压缩的MPEG-4;  


### 调用方式
1. 内嵌式节点调用：  
>Sring mediaURL = "sample.mp4";  
SimpleMediaPlayer simpleMediaPlayer = SimpleMediaPlayer.newInstance(utl);  //默认大小500*400;  
SimpleMediaPlayer simpleMediaPlayer = SimpleMediaPlayer.newInstance(utl，800,600);  
//指定尺寸调用，参数：String URl，int width，int height  
simpleMediaPlayer.setSize(600,400);           //修改内嵌播放器尺寸  
//返回的SimpleMediaPlayer是一个JavaFX Node对象，可以像正常的JavaFX控件使用  

2. 弹出式窗口调用：
>SimpleMediaPlayer simpleMediaPlayer = SimpleMediaPlayer.popup(utl);  //默认大小500*400;  
 SimpleMediaPlayer simpleMediaPlayer = SimpleMediaPlayer.popup(utl，800,600);  
 //指定尺寸调用，参数：String URl，int width，int height  
 //弹出式调用暂不支持通过实例setSize  
 
  
     

