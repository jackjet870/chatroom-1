package com.leeyom.chat.domain;

import java.util.List;

/**
 * 描述: 好友分组信息
 * author:leeyom
 * Date: 17/1/18
 */
public class FriendGroup {

    private String groupname;//好友分组名称
    private int id;//主键
    private List<Friend> friends;//好友列表
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

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }
}
