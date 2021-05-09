package com.nbclass.enums;

/**
 * @version V1.0
 * @date 2020年8月13日
 * @author hkx
 */
public enum ResponseStatus {

    /**
     * 返回状态
     */
    SUCCESS(200, "Successful！"),
    FORBIDDEN(403, "您没有权限访问！"),
    NOT_FOUND(404, "404"),
    ERROR(500, "Server internal error！");

    private Integer code;
    private String message;

    ResponseStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
