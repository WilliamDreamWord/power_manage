package com.wewin.power_manage.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: William
 * @Description: 自定义返回restful风格数据格式 json
 * @Date: 2018/10/20 10:13
 **/
public class ResponseUtil {

    private final int code;
    private final String message;
    private final Map<String, Object> data = new HashMap<>();

    public ResponseUtil(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public int getCode() {

        return code;
    }

    public String getMessage() {
        return message;
    }

    public ResponseUtil putResponseData(String key, Object value) {
        data.put(key, value);
        return this;
    }

    public static ResponseUtil ok() {
        return new ResponseUtil(200, "Ok");
    }

    public static ResponseUtil notFound() {
        return new ResponseUtil(404, "Not Found");
    }

    public static ResponseUtil badRequest() {
        return new ResponseUtil(400, "Bad Request");
    }

    public static ResponseUtil forbidden() {
        return new ResponseUtil(403, "Forbidden");
    }

    public static ResponseUtil unauthorized() {
        return new ResponseUtil(401, "unauthorized");
    }

    public static ResponseUtil serverInternalError() { return new ResponseUtil(500, "Server Internal Error"); }

    public static ResponseUtil customerError() {
        return new ResponseUtil(1001, "customer Error");
    }
}
