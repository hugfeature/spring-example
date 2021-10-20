/*
 * @Author: 丑牛
 * @Date: 2021-10-20 11:07:28
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-10-20 11:17:05
 * @Description: file content
 */
package com.blog.blogspringback.controller;

import com.battcn.boot.swagger.model.DataType;
import com.battcn.boot.swagger.model.ParamType;
import com.blog.blogspringback.common.lang.Result;
import com.blog.blogspringback.entity.User;
import com.blog.blogspringback.service.UserService;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequiresAuthentication
    @GetMapping("/index")
    @ApiOperation(value = "用户", notes = "用户管理")

    public Result index(){
        User user = userService.getById(1L);
        return Result.success(user);
    }

    @PostMapping("/user")
    @ApiOperation(value = "新增用户", notes = "用户管理")
    @ApiImplicitParams({@ApiImplicitParam(name = "who", value = "用户名", dataType = DataType.STRING, paramType = ParamType.QUERY, defaultValue = "xxx")})
    public Result save(@Validated @RequestBody User user){
        return Result.success(user);
    }

    
}
