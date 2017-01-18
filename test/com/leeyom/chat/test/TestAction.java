package com.leeyom.chat.test;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class TestAction extends ActionSupport {

	@Resource
	private TestService testService;

	public String test() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		System.out.println("---> TestAction.execute()");
		testService.saveTwoUsers();
		request.setAttribute("responseText", "success");
		return SUCCESS;
	}
}
