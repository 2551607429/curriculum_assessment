package com.zx.common.enums;

/**
 * @desc 请求操作枚举
 */
public enum  RequestActionType {

    DELETE("删除"),
    UPDATE("修改");

    private String actionName;

    RequestActionType(String actionName) {
        this.actionName=actionName;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }
}
