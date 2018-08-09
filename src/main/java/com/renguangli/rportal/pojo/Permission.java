package com.renguangli.rportal.pojo;

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

    private String description;

    private Integer sort;

    public Permission() {}

    public Permission(Integer permissionId, String url, String permission, String description, Integer sort) {
        this.permissionId = permissionId;
        this.url = url;
        this.permission = permission;
        this.description = description;
        this.sort = sort;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permissionId=" + permissionId +
                ", url='" + url + '\'' +
                ", permission='" + permission + '\'' +
                ", description='" + description + '\'' +
                ", sort=" + sort +
                '}';
    }
}
