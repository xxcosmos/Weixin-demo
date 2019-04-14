package me.xiaoyuu.common;

public class Common {

    public static final String getAccessTokenURL = "https://api.weixin.qq.com/cgi-bin/token?";
    public static final Integer bePickedChance = 2;


    public interface DollMachineKeyWord{
        String man = "男";
        String woman = "女";
        String beDoll = "变成娃娃";
        String getDoll = "抓娃娃";
        String exit = "退出";
        String report = "举报";
        String dollMachine = "娃娃机";
    }
    public interface DollMachineStatus {
        int getDoll = 1;
        int beADoll = 2;
        int exitSys = 0;
        int entrySys = 3;

    }
    public interface MsgField{
        String MsgType = "MsgType";
        String ToUserName = "ToUserName";
        String FromUserName = "FromUserName";
        String Content = "Content";
    }

    public interface MsgType{
        String  text = "text";
        String  image = "image";
        String  link = "link";
        String  location = "location";
        String  shortvideo = "shortvideo";
        String  video = "video";
        String  voice = "voice";
    }

}
