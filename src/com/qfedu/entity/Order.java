package com.qfedu.entity;

import java.util.Date;

public class Order {
      private int id;
      private String orderCode;
      private double totalPrice;
      private Date createDate;
      private String order_status;
      private String username;

    public Order() {
    }

    public Order(int id, String orderCode, double totalPrice, Date createDate, String order_status, String username) {
        this.id = id;
        this.orderCode = orderCode;
        this.totalPrice = totalPrice;
        this.createDate = createDate;
        this.order_status = order_status;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderCode='" + orderCode + '\'' +
                ", totalPrice=" + totalPrice +
                ", createDate=" + createDate +
                ", order_status='" + order_status + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
