package com.leeyom.chat.action;

import com.leeyom.chat.domain.*;

import com.leeyom.chat.service.InitPanelService;
import com.leeyom.chat.service.PanalDataService;
import com.leeyom.chat.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

/**
 * 描述: 面板数据相关的action
 * author:leeyom
 * Date: 17/2/4
 */
@Controller
@Scope("prototype")
public class PanelAction extends ActionSupport {

    @Resource
    UserService userService;
    @Resource
    PanalDataService panalDataService;
    @Resource
    InitPanelService initPanalService;

    /**
     * 描述: 初始化面板
     * 作者: leeyom
     * 时间: 2017-02-04 05:47
     */
    public String initPanel() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String userId = request.getParameter("userId");
        User user = userService.getUserInfoById(Integer.parseInt(userId));
        InitPanel initPanel = initPanalService.getInitPanelById(user.getInitPanelId());
        PanalData panalData = panalDataService.getPanalDataById(initPanel.getPanalDataId());
        System.out.println(initPanel.getPanalDataId());
        //拼接初始化的json字符串
        String jsonStr = "{";
        jsonStr += "\"code\":" + initPanel.getCode() + ",";
        jsonStr += "\"msg\":\"" + initPanel.getMsg() + "\",";
        jsonStr += "\"data\":{\"mine\":{";
        jsonStr += "\"username\":\"" + user.getName() + "\",";
        jsonStr += "\"id\":\"" + user.getId() + "\",";
        jsonStr += "\"status\":\"" + user.getStatus() + "\",";
        jsonStr += "\"sign\":\"" + user.getSign() + "\",";
        jsonStr += "\"avatar\":\"" + user.getAvatar() + "\"";
        jsonStr += "},\"friend\":";

        Set<FriendGroup> friendGroups = panalData.getFriendGroups();
        Set<ChatGroup> chatGroups = panalData.getChatGroups();
        if (friendGroups.size() > 0) {
            jsonStr += "[";
            for (FriendGroup friendGroup : friendGroups) {
                jsonStr += "{\"groupname\":" + "\"" + friendGroup.getGroupname() + "\",";
                jsonStr += "\"id\":" + friendGroup.getId() + ",";

                Set<Friend> friends = friendGroup.getFriends();
                jsonStr += "\"list\":[";
                if (friends.size() > 0) {
                    for (Friend friend : friends) {
                        jsonStr += "{";
                        jsonStr += "\"username\":\"" + friend.getUsername() + "\",";
                        jsonStr += "\"id\":\"" + friend.getId() + "\",";
                        jsonStr += "\"avatar\":\"" + friend.getAvatar() + "\",";
                        jsonStr += "\"sign\":\"" + friend.getSign() + "\",";
                        jsonStr += "\"status\":\"" + friend.getStatus() + "\"";
                        jsonStr += "},";
                    }
                }

                if (jsonStr.endsWith(","))
                    jsonStr = jsonStr.substring(0, jsonStr.length() - 1);
                jsonStr += "]";
            }

            if (jsonStr.endsWith(","))
                jsonStr = jsonStr.substring(0, jsonStr.length() - 1);
            jsonStr += "],\"group\":";

        } else {
            jsonStr += "[],\"group\":";
        }

        if (chatGroups.size() > 0) {
            jsonStr += "[";
            for (ChatGroup chatGroup : chatGroups) {
                jsonStr += "{";
                jsonStr += "\"groupname\":\"" + chatGroup.getGroupname() + "\",";
                jsonStr += "\"id\":\"" + chatGroup.getId() + "\",";
                jsonStr += "\"avatar\":\"" + chatGroup.getAvatar() + "\",";
                jsonStr += "},";
            }

            if (jsonStr.endsWith(","))
                jsonStr = jsonStr.substring(0, jsonStr.length() - 1);
            jsonStr += "]";
        } else {
            jsonStr += "[]";
        }

        jsonStr += "}}";
        request.setAttribute("responseText", jsonStr);
        return SUCCESS;
    }



}
