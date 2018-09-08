package com.renguangli.rportal.pojo;

/**
 * Permission
 *
 * @author renguangli 2018/8/2 13:25
 * @since JDK 1.8
 */
public class Permission {

    private Integer permissionId;

    private Integer parentId;

    private String url;

    private String permission;

    private String name;

    private String parentName;

    private String description;

    private boolean fixed;

    private Integer sort;

    public Permission() {}

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
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
                ", parentId=" + parentId +
                ", url='" + url + '\'' +
                ", permission='" + permission + '\'' +
                ", name='" + name + '\'' +
                ", parentName='" + parentName + '\'' +
                ", description='" + description + '\'' +
                ", fixed='" + fixed + '\'' +
                ", sort=" + sort +
                '}';
    }
}
