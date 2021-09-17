/*
 * @Author: 丑牛
 * @Date: 2021-09-17 11:49:03
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-09-17 15:18:15
 * @Description: file content
 */
package com.example.springjpa.repository;


import javax.annotation.Resource;

import com.example.springjpa.model.User;
import com.example.springjpa.repostiory.UserRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import cn.hutool.core.date.DateUtil;
import cn.hutool.log.Log;
import cn.hutool.log.StaticLog;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailRepositoryTests {
    @Resource
    private UserRepository userRepository;

    @Test
    public void testSave(){
		String formattedDate = DateUtil.now();
		
		userRepository.save(new User("aa", "aa123456","aa@126.com", "aa",  formattedDate));
		userRepository.save(new User("bb", "bb123456","bb@126.com", "bb",  formattedDate));
		userRepository.save(new User("cc", "cc123456","cc@126.com", "cc",  formattedDate));
    }

    @Test
    public void testBaseQuery() {
        String formattedDate = DateUtil.now();
        User user = new User("ff", "ff123456","ff@126.com", "ff",  formattedDate);
        userRepository.findAll();
        userRepository.findById(3L);
        userRepository.save(user);
        userRepository.delete(user);
        userRepository.count();
        userRepository.existsById(3L);
    }

    @Test
    public void testPageQuery(){
        int page = 1;
        int size = 2;
        Pageable pageable = PageRequest.of(page, size);
        userRepository.findALL(pageable);
        userRepository.findByNickName("aa" , pageable);
        System.out.println( userRepository.findByNickName("aa" , pageable));

    }
    
}
