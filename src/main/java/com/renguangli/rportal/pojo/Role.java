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

    private String roleCode;

    private String roleName;

    public Role() {}

    public Role(Integer roleId, String roleCode, String roleName) {
        this.roleId = roleId;
        this.roleCode = roleCode;
        this.roleName = roleName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleCode=" + roleCode +
                ", roleName=" + roleName +
                "}";
    }
}
