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

    private String permission;

    public Permission() {}

    public Permission(Integer permissionId, String url) {
        this.permissionId = permissionId;
        this.url = url;
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

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permissionId=" + permissionId +
                ", url='" + url + '\'' +
                ", permission='" + permission + '\'' +
                '}';
    }
}
