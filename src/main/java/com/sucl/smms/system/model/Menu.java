package com.sucl.smms.system.model;

public class Menu {
    private String menuId;

    private Boolean leaf;

    private String menuCaption;

    private String menuCode;

    private String parentMenuCode;

    private String path;

    private String style;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public Boolean getLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }

    public String getMenuCaption() {
        return menuCaption;
    }

    public void setMenuCaption(String menuCaption) {
        this.menuCaption = menuCaption == null ? null : menuCaption.trim();
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode == null ? null : menuCode.trim();
    }

    public String getParentMenuCode() {
        return parentMenuCode;
    }

    public void setParentMenuCode(String parentMenuCode) {
        this.parentMenuCode = parentMenuCode == null ? null : parentMenuCode.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style == null ? null : style.trim();
    }
}