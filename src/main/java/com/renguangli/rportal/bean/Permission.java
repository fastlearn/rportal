package com.renguangli.rportal.bean;

/**
 * Permission
 *
 * @author renguangli 2018/8/2 13:25
 * @since JDK 1.8
 */
public class Permission {

    private Integer permissionId;

    private String url;

    private String roles;

    private String permissions;

    public Permission() {}

    public Permission(Integer permissionId, String url, String roles, String permissions) {
        this.permissionId = permissionId;
        this.url = url;
        this.roles = roles;
        this.permissions = permissions;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permissionId=" + permissionId +
                ", url=" + url +
                ", roles=" + roles +
                ", permissions=" + permissions +
                "}";
    }

}
