package me.xiaoyuu.pojo;

import java.util.Date;

public class Doll {
    private Integer id;

    private String userId;

    private Integer sex;

    private String contact;

    private Date createTime;

    private Date updateTime;

    private Integer cnt;



    private Integer status;

    private Integer pickChance;

    private Integer bePickedChance;

    private String message;


    public Doll(Integer id, String userId, Integer sex, String contact, Date createTime, Date updateTime, Integer cnt, Integer status, Integer pickChance, Integer bePickedChance, String message) {
        this.id = id;
        this.userId = userId;
        this.sex = sex;
        this.contact = contact;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.cnt = cnt;
        this.status = status;
        this.pickChance = pickChance;
        this.bePickedChance = bePickedChance;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
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

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public Integer getStatus() {
        return status;
    }

    public Doll(String userId, Integer cnt, Integer status) {
        this.userId = userId;
        this.cnt = cnt;
        this.status = status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPickChance() {
        return pickChance;
    }

    public void setPickChance(Integer pickChance) {
        this.pickChance = pickChance;
    }

    public Integer getBePickedChance() {
        return bePickedChance;
    }

    public void setBePickedChance(Integer bePickedChance) {
        this.bePickedChance = bePickedChance;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    @Override
    public String toString() {
        return "Doll{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", sex=" + sex +
                ", contact='" + contact + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", cnt=" + cnt +
                ", status=" + status +
                ", pickChance=" + pickChance +
                ", bePickedChance=" + bePickedChance +
                ", message='" + message + '\'' +
                '}';
    }
}