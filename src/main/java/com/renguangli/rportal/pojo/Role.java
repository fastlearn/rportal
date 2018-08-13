package com.renguangli.rportal.pojo;

import java.io.Serializable;

/**
 * Role
 *
 * @author renguangli 2018/8/2 13:25
 * @since JDK 1.8
 */
public class Role implements Serializable{

    private static final long serialVersionUID = 2203259922381787060L;

    private Integer roleId;

    private String role;

    private String name;

    private String description;

    private boolean disabled;

    public Role() {}

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", role='" + role + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", disabled=" + disabled +
                '}';
    }
}
