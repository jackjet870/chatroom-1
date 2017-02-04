package com.leeyom.chat.action;

import com.leeyom.chat.service.InitPanelService;
import com.leeyom.chat.service.PanalDataService;
import com.leeyom.chat.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

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
    public String initPanel(){

        return SUCCESS;
    }

}
