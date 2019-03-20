package me.xiaoyuu.Service.impl;

import me.xiaoyuu.BaseTest;
import me.xiaoyuu.Service.WeixinService;
import me.xiaoyuu.pojo.ReceiveTextMessage;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;

public class WeixinServiceImplTest extends BaseTest {
    @Autowired
    WeixinService weixinService;

    @Test
    public void getNewAccessToken() {

    }

    @Test
    public void json() {
        ReceiveTextMessage receiveTextMessage = new ReceiveTextMessage("to","from",String.valueOf(new Date().getTime()),"text","111","hello");
        String xml = "<xml>\n" +
                "  <ToUserName>to</ToUserName>\n" +
                "  <FromUserName>from</FromUserName>\n" +
                "  <CreateTime>1552443456792</CreateTime>\n" +
                "  <MsgType>text</MsgType>\n" +
                "  <MsgId>111</MsgId>\n" +
                "  <Content>hello</Content>\n" +
                "</xml>";
    }
}