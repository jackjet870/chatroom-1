package com.leeyom.chat.domain;


/**
 * 描述: 用户
 * 作者: leeyom
 * 时间: 2017-01-18 04:08
 */
public class User {
	private int id;//主键
	private String name;//用户昵称
	private String status;//在线状态,online：在线、hide：隐身
	private String sign;//我的签名
	private String avatar;//头像
	private int initPanelId;//初始化面板Id,用户登录进入,都会初始化加载其对应的面板


	public int getInitPanelId() {
		return initPanelId;
	}

	public void setInitPanelId(int initPanelId) {
		this.initPanelId = initPanelId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}
