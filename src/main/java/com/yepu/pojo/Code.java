package com.yepu.pojo;

import java.util.Date;

public class Code {
    private Integer id;

    private String phone;

    private String code;

    private String type;

    private Date createTime;

    private Date updatetIme;

    private String content;

    private Date requestTime;

    private String resXml;

    private String postData;

    public Code(Integer id, String phone, String code, String type, Date createTime, Date updatetIme, String content, Date requestTime, String resXml, String postData) {
        this.id = id;
        this.phone = phone;
        this.code = code;
        this.type = type;
        this.createTime = createTime;
        this.updatetIme = updatetIme;
        this.content = content;
        this.requestTime = requestTime;
        this.resXml = resXml;
        this.postData = postData;
    }

    public Code() {
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdatetIme() {
        return updatetIme;
    }

    public void setUpdatetIme(Date updatetIme) {
        this.updatetIme = updatetIme;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public String getResXml() {
        return resXml;
    }

    public void setResXml(String resXml) {
        this.resXml = resXml == null ? null : resXml.trim();
    }

    public String getPostData() {
        return postData;
    }

    public void setPostData(String postData) {
        this.postData = postData == null ? null : postData.trim();
    }
}