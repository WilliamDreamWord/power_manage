package com.wewin.power_manage.service;

import com.wewin.power_manage.entity.Manager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: William
 * @Description: Service/manager
 * @Date: 2018/10/22 21:16
 **/
public interface ManagerService {

    Manager login(Manager manager, HttpServletRequest request);

    Manager login(Manager manager);

    int addManager(Manager manager);

    int changePass(Manager manager);

    List<Manager> selectAll();

    List<Object> deleteManger(List<String> managerID);

}
