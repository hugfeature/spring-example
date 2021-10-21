/*
 * @Author: 丑牛
 * @Date: 2021-10-20 11:24:08
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-10-21 09:52:52
 * @Description: 博客服务接口
 */
package com.blog.blogspringback.controller;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.battcn.boot.swagger.model.DataType;
import com.battcn.boot.swagger.model.ParamType;
import com.blog.blogspringback.common.lang.Result;
import com.blog.blogspringback.entity.Blog;
import com.blog.blogspringback.service.BlogService;
import com.blog.blogspringback.util.ShiroUtil;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.hutool.core.bean.BeanUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/blogs")
    @ApiOperation(value = "获取所有博客", notes = "博客管理")
    @ApiImplicitParams({@ApiImplicitParam(name = "currentPage", value = "页数", dataType = DataType.STRING, paramType = ParamType.QUERY, defaultValue = "1")})
    public Result list(@RequestParam(defaultValue = "1") Integer currentPage){
        Page page = new Page(currentPage, 5);
        IPage pageData = blogService.page(page, new QueryWrapper<Blog>().orderByDesc("create"));

        return Result.success(pageData);
    }

    @GetMapping("/blog/{id}")
    @ApiOperation(value = "获取某个博客", notes = "博客管理")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "博客id", dataType = DataType.STRING, paramType = ParamType.QUERY, defaultValue = "1")})
    public Result detail(@PathVariable(name = "id") Long id){
        Blog blog = blogService.getById(id);
        Assert.notNull(blog, "该博客已被删除");
        return Result.success(blog);
    }

    @RequiresAuthentication
    @PostMapping("/blog/edit")
    public Result edit(@Validated @RequestBody Blog blog){
        Blog temp = null;
        if(blog.getId() != null) {
            temp = blogService.getById(blog.getId());
            // 只能编辑自己的文章
            log.info("无编辑权限", ShiroUtil.getProfile().getId());
                Assert.isTrue(temp.getUserId().longValue() == ShiroUtil.getProfile().getId().longValue(), "没有权限编辑");

        } else {

            temp = new Blog();
            temp.setUserId(ShiroUtil.getProfile().getId());
            temp.setCreated(LocalDateTime.now());
            temp.setStatus(0);
        }

        BeanUtil.copyProperties(blog, temp, "id", "userId", "created", "status");
        blogService.saveOrUpdate(temp);

        return Result.success(null);
    }

}

