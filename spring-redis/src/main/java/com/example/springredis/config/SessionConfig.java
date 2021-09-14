/*
 * @Author: 丑牛
 * @Date: 2021-09-14 10:11:03
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-09-14 13:40:49
 * @Description: session配置
 */

package com.example.springredis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

// 设置Session失效时间
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)
public class SessionConfig {
    
}
