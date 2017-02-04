package com.leeyom.chat.action;

import com.leeyom.chat.domain.InitPanel;
import com.leeyom.chat.domain.PanalData;
import com.leeyom.chat.domain.User;
import com.leeyom.chat.service.InitPanelService;
import com.leeyom.chat.service.PanalDataService;
import com.leeyom.chat.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 描述: 跟用户信息相关的action
 * author:leeyom
 * Date: 17/1/19
 */
@Controller
@Scope("prototype")
public class UserAction extends ActionSupport {

    @Resource
    UserService userService;
    @Resource
    PanalDataService panalDataService;
    @Resource
    InitPanelService initPanalService;

    /**
     * 描述: 注册用户
     * 作者: leeyom
     * 时间: 2017-01-19 11:46
     */
    public String saveUser() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String sign = request.getParameter("sign");

        User user = new User();
        user.setName(userName);//用户名
        user.setEmail(email);//邮箱
        user.setPassword(password);//密码
        user.setSign(sign);//签名
        user.setStatus("offline");//默认为离线状态
        user.setAvatar("style/images/avator.jpg");//默认头像

        User userInfo = userService.getUserInfoByEmailAndPassword(email, password);
        if (userInfo!=null){
            request.setAttribute("responseText", "falied");
            return SUCCESS;
        }

        //保存用户信息
        userService.saveOrUpdate(user);

        PanalData panalData = new PanalData();//初始化面板数据
        panalData.setUserId(user.getId());//关联用户id
        //保存面板数据
        panalDataService.saveOrUpdatePanalData(panalData);

        InitPanel initPanel = new InitPanel();//初始化一个面板
        initPanel.setCode(0);//初始化面板成功
        initPanel.setMsg("初始化错误!");//初始化错误提示
        initPanel.setPanalDataId(panalData.getId());//关联面板数据id
        initPanalService.saveOrUpdate(initPanel);

        user.setInitPanelId(initPanel.getId());//当前创建的用户关联面板
        userService.saveOrUpdate(user);

        request.setAttribute("responseText", "success");

        return SUCCESS;
    }

    /**
     * 描述: 用户登录
     * 作者: leeyom
     * 时间: 2017-02-04 02:37
     */
    public String login() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userService.getUserInfoByEmailAndPassword(email, password);
        //将用户的登陆信息存到session中
        HttpSession session = request.getSession();
        session.setAttribute("userId",user.getId());
        if (user != null) {
            //更新状态信息
            user.setStatus("online");
            userService.saveOrUpdate(user);
            request.setAttribute("responseText", "success");
        } else {
            request.setAttribute("responseText", "falied");
        }
        return SUCCESS;
    }
}
