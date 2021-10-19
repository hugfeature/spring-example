/*
 * @Author: 丑牛
 * @Date: 2021-10-19 19:33:03
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-10-19 19:37:07
 * @Description: 服务实现类
 */
package com.blog.blogspringback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.blogspringback.entity.Blog;
import com.blog.blogspringback.mapper.BlogMapper;
import com.blog.blogspringback.service.BlogService;

import org.springframework.stereotype.Service;

@Service
public class BlogserviceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService{
    
}
