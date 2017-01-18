package com.leeyom.chat.domain;

import java.util.List;

/**
 * 描述: 面板详情
 * author:leeyom
 * Date: 17/1/18
 */
public class PanalData {

    private int id;//主键
    private int userId;//用户id
    List<ChatGroup> chatGroups;//聊天群列表
    List<FriendGroup> friendGroups;//好友分组列表

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<ChatGroup> getChatGroups() {
        return chatGroups;
    }

    public void setChatGroups(List<ChatGroup> chatGroups) {
        this.chatGroups = chatGroups;
    }

    public List<FriendGroup> getFriendGroups() {
        return friendGroups;
    }

    public void setFriendGroups(List<FriendGroup> friendGroups) {
        this.friendGroups = friendGroups;
    }
}
