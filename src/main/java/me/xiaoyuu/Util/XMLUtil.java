package me.xiaoyuu.Util;

import com.thoughtworks.xstream.XStream;
import me.xiaoyuu.Util.XStream.XStreamFactory;
import me.xiaoyuu.common.Common;
import me.xiaoyuu.pojo.ReplyTextMessage;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLUtil {

    public static Map<String, String> xmlToMap(HttpServletRequest request) throws Exception {
        Map<String, String> map = new HashMap<>();
        SAXReader reader = new SAXReader();
        Document document = reader.read(request.getInputStream());
        Element root = document.getRootElement();

        @SuppressWarnings("unchecked")
        List<Element> elementList = root.elements();
        for (Element e : elementList) {
            map.put(e.getName(), e.getText());
        }
        return map;
    }

    private static String toXml(Object obj) {
        XStream xStream = XStreamFactory.getXStream();
        xStream.processAnnotations(obj.getClass());
        return xStream.toXML(obj);
    }

    public static String getReplyXML(Map<String, String> map, String content) {
        ReplyTextMessage message = new ReplyTextMessage();
        message.setToUserName(map.get(Common.MsgField.FromUserName));
        message.setFromUserName(map.get(Common.MsgField.ToUserName));
        message.setCreateTime(new Date().getTime());
        message.setMsgType(Common.MsgType.text);
        message.setContent(content);
        return XMLUtil.toXml(message);
    }


}
