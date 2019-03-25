package com.sucl.smms.system.model;

public class Role {
    private String roleId;

    private String description;

    private String roleCaption;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getRoleCaption() {
        return roleCaption;
    }

    public void setRoleCaption(String roleCaption) {
        this.roleCaption = roleCaption == null ? null : roleCaption.trim();
    }
}