package com.wewin.power_manage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan("com.wewin.power_manage.dao")
@EnableCaching
public class PowerManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(PowerManageApplication.class, args);
    }
}
