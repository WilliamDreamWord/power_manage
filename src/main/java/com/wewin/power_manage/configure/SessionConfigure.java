package com.wewin.power_manage.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.RedisFlushMode;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @Author: William
 * @Description: session共享配置
 * @Date: 2018/10/30 11:04
 **/
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60 * 60, redisFlushMode = RedisFlushMode.IMMEDIATE)
public class SessionConfigure {
}
