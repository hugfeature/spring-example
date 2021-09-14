
/**
 * @Author: 丑牛
 * @Date: 2021-09-14 09:50:27
 * @Description: 添加cache的配置类
 */
package com.example.springredis.config;

import java.lang.reflect.Method;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// 开启缓存
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport{

    @Bean
    public KeyGenerator keyGenerator(){
        return new KeyGenerator(){
            @Override
            public Object generate( Object target, Method method, Object... params){
                StringBuilder sBuilder = new StringBuilder();
                sBuilder.append(target.getClass().getName());
                sBuilder.append(method.getName());
                for (Object obj : params){
                    sBuilder.append(obj.toString());
                }
                return sBuilder.toString();
            }
        };
    }

}
