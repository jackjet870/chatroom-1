package com.leeyom.chat.domain;

import java.util.List;

/**
 * 描述: 初始化面板
 * author:leeyom
 * Date: 17/1/18
 */
public class InitPanel {
    private int id;//主键
    private int code;//0表示成功，其它表示失败
    private String msg;//失败信息
    private int panalDataId;//面板详情id

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPanalDataId() {
        return panalDataId;
    }

    public void setPanalDataId(int panalDataId) {
        this.panalDataId = panalDataId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
