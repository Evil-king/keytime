package com.yepu.pojo;

import java.util.Date;

public class User {
    private Integer id;

    private String phone;

    private String uutype;

    private String uuid;

    private Date createTime;

    private Date updateTime;

    public User(Integer id, String phone, String uutype, String uuid, Date createTime, Date updateTime) {
        this.id = id;
        this.phone = phone;
        this.uutype = uutype;
        this.uuid = uuid;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getUutype() {
        return uutype;
    }

    public void setUutype(String uutype) {
        this.uutype = uutype == null ? null : uutype.trim();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}