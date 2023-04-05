package com.zjxu.hwl.entity;

public class MessageEntity {
    private String id;   //
    private String img;
    private String des;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "MessageEntity{" +
                "id='" + id + '\'' +
                ", img='" + img + '\'' +
                ", des='" + des + '\'' +
                '}';
    }


}
