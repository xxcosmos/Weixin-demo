package me.xiaoyuu.Service.impl;

import me.xiaoyuu.Service.WeixinService;
import me.xiaoyuu.Util.XMLUtil;
import me.xiaoyuu.common.Common;
import me.xiaoyuu.common.EnumMap;
import me.xiaoyuu.common.TipMsg;
import me.xiaoyuu.dao.DollMapper;
import me.xiaoyuu.pojo.Doll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Service
public class WeixinServiceImpl implements WeixinService {

    @Autowired
    DollMapper dollMapper;

    public String handleMessage(HttpServletRequest request) throws Exception {
        //得到消息map
        request.setCharacterEncoding("UTF-8");
        Map<String, String> map = XMLUtil.xmlToMap(request);
        System.out.println(map);
        String userName = map.get(Common.MsgField.FromUserName);

        //非文字消息
        if (!map.get(Common.MsgField.MsgType).equals(Common.MsgType.text)) {
            return "success";
        }
        String content = map.get(Common.MsgField.Content);
        Doll doll = dollMapper.getDollByUserId(userName);
        //进入娃娃机系统
        if (content.contains(Common.DollMachineKeyWord.dollMachine) || content.contains(Common.DollMachineKeyWord.report) || (doll.getUserId() != null && doll.getStatus() != Common.DollMachineStatus.exitSys)) {
            return dollMachine(map);
        }

        return "success";
    }

    /**
     * 娃娃机系统
     *
     * @param map map消息
     * @return 回复消息
     */
    private String dollMachine(Map<String, String> map) {
        String userName = map.get(Common.MsgField.FromUserName);
        String content = map.get(Common.MsgField.Content);

        if (content.contains(Common.DollMachineKeyWord.exit)) {
            dollMapper.updatePickStatusByUserId(userName, Common.DollMachineStatus.exitSys);
            return "success";
        }
        if (content.contains(Common.DollMachineKeyWord.report)) {
            return XMLUtil.getReplyXML(map, TipMsg.reportTip);
        }
        if (content.contains(Common.DollMachineKeyWord.dollMachine)) {
            if (dollMapper.checkUserId(userName) == 0) {
                //首次进入娃娃机
                dollMapper.insert(new Doll(userName, 1, Common.DollMachineStatus.entrySys));
            } else {
                //非首次进入
                dollMapper.updateCntByUserId(userName, 1);
                dollMapper.updatePickStatusByUserId(userName, Common.DollMachineStatus.entrySys);
            }
            return XMLUtil.getReplyXML(map, TipMsg.welcomeTip);
        }

        Doll doll = dollMapper.getDollByUserId(userName);
        System.out.println(doll);
        Integer pickStatus = doll.getStatus();
        Integer cnt = doll.getCnt();
        int bePickedChance = doll.getBePickedChance();
        if (cnt == 1 && content.contains(Common.DollMachineKeyWord.getDoll)) {
            if (bePickedChance == 0) {
                return XMLUtil.getReplyXML(map, TipMsg.getDollWithoutBeADollErrorMsg);
            }
            int pickChance = doll.getPickChance();
            if (pickChance == 0) {
                return XMLUtil.getReplyXML(map, TipMsg.getDollBeyondLimitErrorMsg);
            }
            dollMapper.updatePickStatusByUserId(userName, Common.DollMachineStatus.getDoll);
            dollMapper.updateCntByUserId(userName, 2);
            return XMLUtil.getReplyXML(map, TipMsg.queryDollSexTip);
        }
        if (cnt == 1 && content.contains(Common.DollMachineKeyWord.beDoll)) {
            if (bePickedChance > 0) {
                return XMLUtil.getReplyXML(map, TipMsg.toBeDollErrorMsg);
            }

            dollMapper.updatePickStatusByUserId(userName, Common.DollMachineStatus.beADoll);
            dollMapper.updateCntByUserId(userName, 2);
            return XMLUtil.getReplyXML(map, TipMsg.queryUserSexTip);
        }

        if (pickStatus == Common.DollMachineStatus.getDoll && cnt == 2) {
            Doll getDoll;
            if (content.contains(Common.DollMachineKeyWord.man)) {
                getDoll = dollMapper.getOneDoll(Integer.valueOf(EnumMap.man.getValue()));
            } else if (content.contains(Common.DollMachineKeyWord.woman)) {
                getDoll = dollMapper.getOneDoll(Integer.valueOf(EnumMap.woman.getValue()));
            } else {
                return XMLUtil.getReplyXML(map, TipMsg.ErrorMsg);
            }
            String information = getInformation(getDoll);
            dollMapper.updatePickChance(userName);
            dollMapper.updatePickStatusByUserId(userName, Common.DollMachineStatus.entrySys);
            dollMapper.updateBePickedChance(getDoll.getUserId(), getDoll.getBePickedChance() - 1);
            dollMapper.updateCntByUserId(userName, 1);
            return XMLUtil.getReplyXML(map, information);
        }

        if (pickStatus == Common.DollMachineStatus.beADoll && cnt == 2) {
            //已输入性别
            //判断性别
            if (content.contains(Common.DollMachineKeyWord.man)) {
                dollMapper.updateSex(userName, Integer.valueOf(EnumMap.man.getValue()));
            } else if (content.contains(Common.DollMachineKeyWord.woman)) {
                dollMapper.updateSex(userName, Integer.valueOf(EnumMap.woman.getValue()));
            } else {
                return XMLUtil.getReplyXML(map, TipMsg.ErrorMsg);
            }
            dollMapper.updateCntByUserId(userName, 3);
            return XMLUtil.getReplyXML(map, TipMsg.wordTip);
        }
        if (cnt == 3 && pickStatus == Common.DollMachineStatus.beADoll) {
            //已输入留言
            dollMapper.updateMessage(userName, content);
            dollMapper.updateCntByUserId(userName, 4);
            return XMLUtil.getReplyXML(map, TipMsg.contactTip);
        }
        if (cnt == 4 && pickStatus == Common.DollMachineStatus.beADoll) {
            //已输入联系方式
            dollMapper.updateContact(userName, content);
            dollMapper.updateCntByUserId(userName, 1);
            dollMapper.updatePickStatusByUserId(userName, 3);
            dollMapper.updateBePickedChance(userName, Common.bePickedChance);
            return XMLUtil.getReplyXML(map, TipMsg.successTip);
        }
        return "success";
    }

    private String getInformation(Doll doll) {
        return "留言:" + doll.getMessage() + '\n' + "联系方式：" + doll.getContact();
    }


}
