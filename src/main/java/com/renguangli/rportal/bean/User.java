package com.renguangli.rportal.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * User
 *
 * @author renguangli 2018/8/2 13:25
 * @since JDK 1.8
 */
public class User implements Serializable{

    private static final long serialVersionUID = -9158393508008723437L;

    private Integer userId;

    private String username;

    private String password;

    private String phoneNumber;

    private String email;

    private Date createDatetime;

    private Date updateDatetime;

    public User() {}

    public User(String username) {
        this.username = username;
    }

    public User(Integer userId, String username, String password, String phoneNumber, String email, Date createDatetime, Date updateDatetime) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.createDatetime = createDatetime;
        this.updateDatetime = updateDatetime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username=" + username +
                ", password=" + password +
                ", phoneNumber=" + phoneNumber +
                ", email=" + email +
                ", createDatetime=" + createDatetime +
                ", updateDatetime=" + updateDatetime +
                "}";
    }

}
