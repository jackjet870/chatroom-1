package com.leeyom.chat.action;

import com.leeyom.chat.test.TestService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
@Scope("prototype")
public class TestAction2 extends ActionSupport {

    @Resource
    private TestService testService;

    public String test() throws Exception {
        System.out.println("---> TestAction.execute()");
        testService.saveTwoUsers();
        return "success";
    }
}