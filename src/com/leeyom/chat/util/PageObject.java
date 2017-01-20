package com.leeyom.chat.util;

/**
 * 数据分页组件: PageObject
 */
public class PageObject {
    /**
     * 当前�?
     */
    private int pageCurrent = 1;

    /**
     * 每页记录数（默认每页12条）
     */
    private int pageSize = 12;

    /**
     * 总的页数
     */
    private int pageCount;

    /**
     * 总的记录�?
     */
    private int rowCount;

    /**
     * 排序字段
     */
    private String sort;

    /**
     * 排序方向,asc或desc
     */
    private String direction;

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageCurrent() {
        return pageCurrent;
    }

    public void setPageCurrent(int pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
