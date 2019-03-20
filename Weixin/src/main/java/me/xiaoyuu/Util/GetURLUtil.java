package me.xiaoyuu.Util;

import java.util.Map;
import java.util.Set;

public class GetURLUtil {

    public static String getUrl(String url, Map<String, String> map) {
        StringBuilder string = new StringBuilder().append(url).append("?");
        Set<Map.Entry<String, String>> set = map.entrySet();
        for (Map.Entry entry : set) {
            string.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        string.deleteCharAt(string.lastIndexOf("&"));
        return string.toString();
    }
}
