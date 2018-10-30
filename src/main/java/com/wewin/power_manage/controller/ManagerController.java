package com.wewin.power_manage.controller;

import com.wewin.power_manage.entity.Manager;
import com.wewin.power_manage.service.ManagerService;
import com.wewin.power_manage.util.JWTUtil;
import com.wewin.power_manage.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * @Author: William
 * @Description: Controller/manager
 * @Date: 2018/10/25 11:01
 **/
@RestController
@RequestMapping("/Manager")
@Api(value = "manager", description = "Manager API")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    /**
     * 登陆
     *
     * @param request
     * @param response
     * @return responseUtil
     */
    @ApiOperation(value = "登录",notes = "根据用户名和密码登录")
    @ApiImplicitParam(name = "manager", value = "manager对象", required = true, dataType = "String", paramType = "path")
    @GetMapping(value = "/login")
    public @ResponseBody ResponseUtil login(HttpServletRequest request, HttpServletResponse response) {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");

        Manager manager = new Manager();

        manager.setAccountName(request.getParameter("account_name"));
        manager.setAccountPass(request.getParameter("account_pass"));

        System.out.println(manager.toString());

        try {
            Manager manager1 = managerService.login(manager, request);
            ResponseUtil responseUtil = ResponseUtil.ok();

            String token = JWTUtil.sign(manager1, 30L * 24L * 3600L * 1000L);
            if (token != null ) {
                responseUtil.putResponseData("token", token);
            }

            return responseUtil;
        } catch (Exception e) {
            ResponseUtil responseUtil1 = ResponseUtil.serverInternalError();
            responseUtil1.putResponseData("error", e.getClass());
            e.printStackTrace();
            return responseUtil1;
        }


    }

    /**
     *
     * 查看所有管理者
     * @return List
     */
    @ApiOperation(value = "查看所有管理者", notes = "查看所有数据库中的管理者")
    @GetMapping(value = "/selectAll")
    public @ResponseBody List<Object> selectAll(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println(request.getSession().getAttribute("user"));

        List<Object> list = new ArrayList<>();
        String session_id = request.getSession().getId();
        list.add(0, managerService.selectAll());
        list.add(1, session_id);

//        if(request.getSession().getAttribute("user") == null) {
//            System.out.println("用户没有登陆");
//            list.add("拦截器拦截，用户没有登陆");
//            response.sendRedirect("/Manager/login");
//            return list;
//        } else
        return list;
    }


    /**
     *
     * 添加管理员
     * @param manager
     * @return responseUtil
     */
    @ApiOperation(value = "添加管理者", notes = "添加管理员")
    @PostMapping(value = "/addManager")
    public @ResponseBody ResponseUtil addManager(Manager manager) {

        ResponseUtil responseUtil = ResponseUtil.ok();
        ResponseUtil responseUtil1 = ResponseUtil.serverInternalError();
        manager.setManagerId(UUID.randomUUID().toString());

        int result = managerService.addManager(manager);

        switch (result) {
            case -2:
                responseUtil.putResponseData("fail",result);
                responseUtil.putResponseData("msg", "重复账户");
                break;
            case 1:
                Manager manager1 = managerService.login(manager);
                String token = JWTUtil.sign(manager1, 30L * 24L * 3600L * 1000L);
                responseUtil.putResponseData("new_manager", manager1);
                responseUtil.putResponseData("token", token);
                responseUtil.putResponseData("success", result);
                break;
            case -1:
                responseUtil1.putResponseData("error",result);
                return responseUtil1;
        }

        return responseUtil;

    }

    /**
     *
     * 删除管理员
     * @param nameList
     * @return list
     */
    @ApiOperation(value = "删除管理员", notes = "批量删除管理员")
    @DeleteMapping(value = "/deleteManager")
    public @ResponseBody ResponseUtil deleteManager(List<String> nameList) {

        List<Object> list = new ArrayList<>();

        try {
            ResponseUtil responseUtil = ResponseUtil.ok();
            list = managerService.deleteManger(nameList);
            responseUtil.putResponseData("manager", list);
            return responseUtil;
        } catch (Exception e) {
            ResponseUtil responseUtil1 = ResponseUtil.serverInternalError();
            responseUtil1.putResponseData("error",e.getClass());
            e.printStackTrace();
            return responseUtil1;
        }
    }

    /**
     *
     * 修改管理员信息
     * @param manager
     * @return responseUtil
     */
    @ApiOperation(value = "修改管理员信息", notes = "修改管理员信息")
    @PutMapping(value = "/updateManager")
    public @ResponseBody ResponseUtil updateManager(Manager manager) {

        ResponseUtil responseUtil1 = ResponseUtil.serverInternalError();

        try {
            ResponseUtil responseUtil = ResponseUtil.ok();
            int result = managerService.changePass(manager);
            switch (result) {
                case -1:
                    responseUtil1.putResponseData("error", result);
                    break;
                case 1:
                    responseUtil.putResponseData("success", result);
                    break;
            }
            return responseUtil;
        } catch (Exception e) {
            responseUtil1.putResponseData("error", e.getClass());
            e.printStackTrace();
            return responseUtil1;
        }
    }

    /**
     * 推出系统
     * @param request
     * @param response
     * @return ResponseUtil
     */
    @ApiOperation(value = "推出系统", notes = "推出系统")
    @PostMapping(value = "/quit")
    public @ResponseBody ResponseUtil quit(HttpServletRequest request, HttpServletResponse response) {

        ResponseUtil responseUtil = ResponseUtil.ok();
        try {
            request.getSession().invalidate();
        } catch (Exception e) {
            e.printStackTrace();
            ResponseUtil responseUtil1 = ResponseUtil.serverInternalError();
            return responseUtil1.putResponseData("msg", e.getClass());
        }

        System.out.println("sessionid" + request.getSession().getId());
        return responseUtil.putResponseData("msg", "成功退出系统");
    }

}
