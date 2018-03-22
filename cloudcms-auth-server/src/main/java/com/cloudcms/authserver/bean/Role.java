package com.cloudcms.authserver.bean;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable {
    private Integer roleId;

    private Integer siteId;

    private String roleName;

    private Integer priority;

    private short isSuper;

    private Integer roleLevel;

    private List<RolePermission> permissions;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public short getIsSuper() {
        return isSuper;
    }

    public void setIsSuper(short isSuper) {
        this.isSuper = isSuper;
    }

    public Integer getRoleLevel() {
        return roleLevel;
    }

    public void setRoleLevel(Integer roleLevel) {
        this.roleLevel = roleLevel;
    }

    public List<RolePermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<RolePermission> permissions) {
        this.permissions = permissions;
    }
}
