package com.zxj.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Timestamp;

// Order实体定义

public class Order {
    private Integer oId;
    private String userName;
    private String isbn;
    private Integer count;
    private String orderDate;

    public Integer getId() {
        return oId;
    }

    public void setId(Integer id) {
        this.oId = oId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getDate() {
        return orderDate;
    }

    public void setDate(String date) {
        this.orderDate = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oId=" + oId +
                ", userName='" + userName + '\'' +
                ", isbn='" + isbn + '\'' +
                ", count=" + count +
                ", orderDate=" + orderDate +
                '}';
    }
}
