package com.hand.exam.utiils;

import java.io.Serializable;

public class ResultBean<T> implements Serializable {
    private Integer code;//1表示返回正常，0表示返回错误
    private String mes;//返回信息
    private T t;//返回数据封装

    public ResultBean(Integer code, String mes, T t) {
        this.code = code;
        this.mes = mes;
        this.t = t;
    }

    public ResultBean() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "code=" + code +
                ", mes='" + mes + '\'' +
                ", t=" + t +
                '}';
    }
}
