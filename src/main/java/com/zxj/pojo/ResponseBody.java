package com.zxj.pojo;

import com.zxj.common.DateUtil;

import java.io.Serializable;

/**
 * 功能描述：封装响应的数据结构
 */
public class ResponseBody<T> implements Serializable {

    private String date= DateUtil.getCurrentDateStr("yyyy-MM-dd HH:mm:ss");//时间
    private int status=200;//状态码 默认200响应成功
    private T data;//接口返回的数据
    private InfoMsg info;//消息内容

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public InfoMsg getInfo() {
        return info;
    }

    public void setInfo(InfoMsg info) {
        this.info = info;
    }
}
