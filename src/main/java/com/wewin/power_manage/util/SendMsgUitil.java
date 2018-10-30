package com.wewin.power_manage.util;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.json.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.util.JSONPObject;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Author: William
 * @Description: response返回json格式数据
 * @Date: 2018/10/29 09:32
 **/
public class SendMsgUitil {

    /**
     * 发送消息
     *
     * @param response
     * @param str
     * @throws Exception
     */
    public static void sendMessage(HttpServletResponse response, String str) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(str);
        writer.close();
        response.flushBuffer();
    }

    /**
     * 将某个对象转换成json格式发送至客户端
     *
     * @param response
     * @param obj
     * @throws Exception
     */
    public static void sendJsonMsg(HttpServletResponse response, Object obj) throws Exception{
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(com.alibaba.fastjson.JSONObject.toJSONString(obj,SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat));
        writer.close();
        response.flushBuffer();
    }
}