package com.leeyom.chat.domain;

/**
 * 描述: 好友信息
 * author:leeyom
 * Date: 17/1/18
 */
public class Friend {

    private String username;//名称
    private int id;//主键
    private String avatar;//头像
    private String sign;//好友签名
    private String status;//在线状态,若值为offline代表离线，online或者不填为在线
    private FriendGroup friendGroup;//所属好友分组

    public FriendGroup getFriendGroup() {
        return friendGroup;
    }

    public void setFriendGroup(FriendGroup friendGroup) {
        this.friendGroup = friendGroup;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
