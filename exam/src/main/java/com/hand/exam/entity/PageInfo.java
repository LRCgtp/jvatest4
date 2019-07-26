package com.hand.exam.entity;

import java.io.Serializable;
import java.util.List;

public class PageInfo<T> implements Serializable {
    private Integer pageNo;//当前页
    private Integer pageSize;//每页返回的条数
    private Integer count;//总记录数
    private List<T> t;//封装数据
    private int page;//总页数
    private String sort = "ASC";

    public PageInfo(Integer pageNo, Integer pageSize, Integer count, List<T> t, int page, String sort) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.count = count;
        this.t = t;
        this.page = page;
        this.sort = sort;
    }

    public PageInfo() {
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getT() {
        return t;
    }

    public void setT(List<T> t) {
        this.t = t;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", count=" + count +
                ", t=" + t +
                ", page=" + page +
                ", sort='" + sort + '\'' +
                '}';
    }
}
