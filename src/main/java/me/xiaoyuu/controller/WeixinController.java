package me.xiaoyuu.controller;

import me.xiaoyuu.Service.WeixinService;
import me.xiaoyuu.Util.WeixinUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@Controller
public class WeixinController {

    @Autowired
    WeixinService weixinService;

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    @ResponseBody
    public String checkValid(@RequestParam String signature, @RequestParam String timestamp, @RequestParam String nonce, @RequestParam String echostr) {
        if (WeixinUtil.CheckValid(timestamp, nonce, signature)) {
            return echostr;
        }
        return "";
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    @ResponseBody
    public String handleMessage(HttpServletRequest request) {
        try {
           return weixinService.handleMessage(request);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
