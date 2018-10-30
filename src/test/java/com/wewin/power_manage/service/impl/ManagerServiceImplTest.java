package com.wewin.power_manage.service.impl;

import com.wewin.power_manage.dao.ManagerMapper;
import com.wewin.power_manage.entity.Manager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: William
 * @Description: test
 * @Date: 2018/10/24 11:37
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerServiceImplTest {

    @SuppressWarnings("all")
    @Autowired(required = true)
    private ManagerMapper managerMapper;

    @Test
    public void login() {

        Manager manager = new Manager();
        manager.setAccountName("william");
        manager.setAccountPass("123456");
        System.out.println(managerMapper.selectByAccount(manager));
    }

    @Test
    public void addManager() {
    }

    @Test
    public void changePass() {
    }

    @Test
    public void selectAll() {
        System.out.println(managerMapper.selectAll().toString());
    }

    @Test
    public void deleteManger() {
    }
}