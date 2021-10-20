/*
 * @Author: 丑牛
 * @Date: 2021-10-19 19:36:09
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-10-20 16:24:33
 * @Description: 服务实现类
 */
package com.blog.blogspringback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.blogspringback.entity.User;
import com.blog.blogspringback.mapper.UserMapper;
import com.blog.blogspringback.service.UserService;

import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
    
}
