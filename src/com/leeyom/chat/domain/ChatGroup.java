package com.leeyom.chat.domain;

/**
 * 描述: 聊天群
 * author:leeyom
 * Date: 17/1/18
 */
public class ChatGroup {

    private String groupname;//群名称
    private int id;//主键id
    private String avatar;//群头像
    private PanalData panalData;//面板详情

    public PanalData getPanalData() {
        return panalData;
    }

    public void setPanalData(PanalData panalData) {
        this.panalData = panalData;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
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

}
