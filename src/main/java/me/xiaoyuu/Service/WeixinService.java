package me.xiaoyuu.Service;

import javax.servlet.http.HttpServletRequest;

public interface WeixinService {
    String handleMessage(HttpServletRequest request) throws Exception;
}
