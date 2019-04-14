package me.xiaoyuu.pojo;


import com.thoughtworks.xstream.annotations.XStreamAlias;
import me.xiaoyuu.Util.XStream.XStreamCDATA;
@XStreamAlias("xml")
public class ReceiveTextMessage {
    @XStreamAlias("ToUserName")
    @XStreamCDATA
    private String ToUserName;
    @XStreamAlias("FromUserName")
    @XStreamCDATA

    private String FromUserName;


    private String CreateTime;


    private String MsgType;

    private String MsgId;


    private String Content;

    @Override
    public String toString() {
        return "ReceiveTextMessage{" +
                "ToUserName='" + ToUserName + '\'' +
                ", FromUserName='" + FromUserName + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                ", MsgType='" + MsgType + '\'' +
                ", MsgId='" + MsgId + '\'' +
                ", Content='" + Content + '\'' +
                '}';
    }
    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public ReceiveTextMessage(String toUserName, String fromUserName, String createTime, String msgType, String msgId, String content) {
        ToUserName = toUserName;
        FromUserName = fromUserName;
        CreateTime = createTime;
        MsgType = msgType;
        MsgId = msgId;
        Content = content;
    }
}
