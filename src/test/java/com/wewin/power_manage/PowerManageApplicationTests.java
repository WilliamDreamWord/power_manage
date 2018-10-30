package com.wewin.power_manage;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PowerManageApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() {
        stringRedisTemplate.opsForValue().set("test","redis");
        Assert.assertEquals("redis",stringRedisTemplate.opsForValue().get("test"));
    }

}
