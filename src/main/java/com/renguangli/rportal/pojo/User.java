package com.renguangli.rportal.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * User
 *
 * @author renguangli 2018/8/2 13:25
 * @since JDK 1.8
 */
public class User implements Serializable{

    private static final long serialVersionUID = -9158393508008723437L;

    /**
     * 账号锁定
     */
    public static final Integer LOCKED = 1;

    private Integer userId;

    private String username;

    private String password;

    private String salt;

    /**
     * 账号是否锁定，1锁定，0未锁定
     */
    private Integer locked;

    /**
     * 默认90天过期
     */
    private Integer expired = 90;

    /**
     * 用户真实姓名/昵称
     */
    private String name;

    private String phoneNumber;

    private String email;

    /**
     * 用户创建日期
     */
    private LocalDateTime createDatetime;

    /**
     * 用户更新日期
     */
    private LocalDateTime updateDatetime;

    /**
     * 密码更新日期
     */
    private LocalDateTime passwordUpdateDatetime;

    public User() {}

    public User(Integer userId) {
        this.userId = userId;
    }

    public User(String username) {
        this.username = username;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public Integer getExpired() {
        return expired;
    }

    public void setExpired(Integer expired) {
        this.expired = expired;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public LocalDateTime getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(LocalDateTime createDatetime) {
        this.createDatetime = createDatetime;
    }

    public LocalDateTime getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(LocalDateTime updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public LocalDateTime getPasswordUpdateDatetime() {
        return passwordUpdateDatetime;
    }

    public void setPasswordUpdateDatetime(LocalDateTime passwordUpdateDatetime) {
        this.passwordUpdateDatetime = passwordUpdateDatetime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", locked=" + locked +
                ", expired=" + expired +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", createDatetime=" + createDatetime +
                ", updateDatetime=" + updateDatetime +
                ", passwordUpdateDatetime=" + passwordUpdateDatetime +
                '}';
    }
}
