
/*
 * @Author: 丑牛
 * @Date: 2021-09-14 14:49:10
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-09-14 15:20:02
 * @Description: redis test
 */
package com.example.springredis;

import java.util.concurrent.TimeUnit;

import com.example.springredis.model.User;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@ RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private  RedisTemplate redisTemplate;

    @Test
    public void test() throws Exception{
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testObj() throws Exception{
        User user  = new User("aa@126.com", "aa", "aa123456", "aa","123");
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("com.neox", user);
        operations.set("com.neo.f", user,1, TimeUnit.SECONDS);
        Thread.sleep(1000);
        
        boolean exists = redisTemplate.hasKey("com.neo.f");
        if (exists){
            System.out.println("zhen");
        }else{
            System.out.println("jia");
        }
    }

}