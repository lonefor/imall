package com.situ.mall.util;

public class LayUITableJSONResult {
    public static final int ERROR = 1;
    public static final int OK = 0;

    // 当前状态（程序员判断状态）:成功、失败、未登录、没有权限
    // 当前登录是成功还是失败要告诉前台，前台才能知道弹出的提示框用errorMsg、okMsg
    private Integer code;
    // 描述信息（主要是给用户看的提示信息）
    private String msg;
    // 后台返回给前端的数据 Object， User、List<User>
    private Object data;
    // 总的数量
    private Integer count;

	/*public boolean isOk() {
		return code == OK;
	}*/

    public LayUITableJSONResult() {
    }

    public LayUITableJSONResult(Integer code) {
        this.code = code;
    }

    public LayUITableJSONResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public LayUITableJSONResult(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public LayUITableJSONResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public LayUITableJSONResult(Integer code, Integer count, Object data) {
        this.code = code;
        this.count = count;
        this.data = data;
    }

    // 告诉前台成功：code
    public static LayUITableJSONResult ok() {
        return new LayUITableJSONResult(OK);
    }

    // 告诉前台成功：code、msg
    public static LayUITableJSONResult ok(String msg) {
        return new LayUITableJSONResult(OK, msg);
    }

    // 告诉前台成功：code、data
    public static LayUITableJSONResult ok(Object data) {
        return new LayUITableJSONResult(OK, data);
    }

    // 告诉前台成功：code、msg、data
    public static LayUITableJSONResult ok(String msg, Object data) {
        return new LayUITableJSONResult(OK, msg, data);
    }

    // 告诉前台成功：code、data
    public static LayUITableJSONResult ok(Integer count, Object data) {
        return new LayUITableJSONResult(OK, count, data);
    }

    // 告诉前台成功：code
    public static LayUITableJSONResult error() {
        return new LayUITableJSONResult(ERROR);
    }

    // 告诉前台成功：code、msg
    public static LayUITableJSONResult error(String msg) {
        return new LayUITableJSONResult(ERROR, msg);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
