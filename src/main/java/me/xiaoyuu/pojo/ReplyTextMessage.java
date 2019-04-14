package me.xiaoyuu.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import me.xiaoyuu.Util.XStream.XStreamCDATA;

@XStreamAlias("xml")
public class ReplyTextMessage {

    @XStreamAlias("ToUserName")
    @XStreamCDATA
    private String toUserName;

    @XStreamAlias("FromUserName")
    @XStreamCDATA
    private String fromUserName;

    @XStreamAlias("CreateTime")
    private Long createTime;

    @XStreamAlias("MsgType")
    @XStreamCDATA
    private String msgType;

    @XStreamAlias("Content")
    @XStreamCDATA
    private String content;

    public String getToUserName() {
        return toUserName;
    }

    public ReplyTextMessage() {
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ReplyTextMessage(String toUserName, String fromUserName, Long createTime, String msgType, String content) {
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.createTime = createTime;
        this.msgType = msgType;
        this.content = content;
    }
}
