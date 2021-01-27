package com.qfedu.entity;

public class GoodsType {
      private int id;
      private String typename;

    public GoodsType() {
    }

    public GoodsType(int id, String typename) {
        this.id = id;
        this.typename = typename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public String toString() {
        return "GoodsType{" +
                "id=" + id +
                ", typename='" + typename + '\'' +
                '}';
    }
}
