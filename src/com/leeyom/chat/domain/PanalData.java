package com.leeyom.chat.domain;

import java.util.List;
import java.util.Set;

/**
 * 描述: 面板详情
 * author:leeyom
 * Date: 17/1/18
 */
public class PanalData {

    private int id;//主键
    private int userId;//用户id
    Set<ChatGroup> chatGroups;//聊天群列表
    Set<FriendGroup> friendGroups;//好友分组列表

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

    public Set<ChatGroup> getChatGroups() {
        return chatGroups;
    }

    public void setChatGroups(Set<ChatGroup> chatGroups) {
        this.chatGroups = chatGroups;
    }

    public Set<FriendGroup> getFriendGroups() {
        return friendGroups;
    }

    public void setFriendGroups(Set<FriendGroup> friendGroups) {
        this.friendGroups = friendGroups;
    }
}
