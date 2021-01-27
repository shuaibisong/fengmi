package com.qfedu.entity;

import java.util.Date;

public class Goods {
    private int id;
    private String goodsName;
    private double price;
    private int score;
    private String deployDate;
    private String imgPath;
    private String comment;
    private int typeId;
    private String typename;

    public Goods() {
    }

    public Goods(int id, String goodsName, double price, int score, String deployDate, String imgPath, String comment, int typeId, String typename) {
        this.id = id;
        this.goodsName = goodsName;
        this.price = price;
        this.score = score;
        this.deployDate = deployDate;
        this.imgPath = imgPath;
        this.comment = comment;
        this.typeId = typeId;
        this.typename = typename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDeployDate() {
        return deployDate;
    }

    public void setDeployDate(String deployDate) {
        this.deployDate = deployDate;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", price=" + price +
                ", score=" + score +
                ", deployDate='" + deployDate + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", comment='" + comment + '\'' +
                ", typeId=" + typeId +
                ", typename='" + typename + '\'' +
                '}';
    }
}
