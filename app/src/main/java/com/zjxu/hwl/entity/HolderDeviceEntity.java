package com.zjxu.hwl.entity;

public class HolderDeviceEntity {
    private String id;   //
    private String title;   //
    private String dev_type;   //
    private String mac;   //
    private String created;   //
    private String updated;   //
    private String deviceimg;   //
    private String description;   //
    private String template;   //
    private String user;   //
    private String decicelinks;   //
    private String holders;   //
    private String updatastreams;   //
    private String downdatastreams;   //
    private String is_bind;   //
    private int status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDev_type() {
        return dev_type;
    }

    public void setDev_type(String dev_type) {
        this.dev_type = dev_type;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getDeviceimg() {
        return deviceimg;
    }

    public void setDeviceimg(String deviceimg) {
        this.deviceimg = deviceimg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDecicelinks() {
        return decicelinks;
    }

    public void setDecicelinks(String decicelinks) {
        this.decicelinks = decicelinks;
    }

    public String getHolders() {
        return holders;
    }

    public void setHolders(String holders) {
        this.holders = holders;
    }

    public String getUpdatastreams() {
        return updatastreams;
    }

    public void setUpdatastreams(String updatastreams) {
        this.updatastreams = updatastreams;
    }

    public String getDowndatastreams() {
        return downdatastreams;
    }

    public void setDowndatastreams(String downdatastreams) {
        this.downdatastreams = downdatastreams;
    }

    public String getIs_bind() {
        return is_bind;
    }

    public void setIs_bind(String is_bind) {
        this.is_bind = is_bind;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "HolderDeviceEntity{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", dev_type='" + dev_type + '\'' +
                ", mac='" + mac + '\'' +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                ", deviceimg='" + deviceimg + '\'' +
                ", description='" + description + '\'' +
                ", template='" + template + '\'' +
                ", user='" + user + '\'' +
                ", decicelinks='" + decicelinks + '\'' +
                ", holders='" + holders + '\'' +
                ", updatastreams='" + updatastreams + '\'' +
                ", downdatastreams='" + downdatastreams + '\'' +
                ", is_bind='" + is_bind + '\'' +
                ", status=" + status +
                '}';
    }
}