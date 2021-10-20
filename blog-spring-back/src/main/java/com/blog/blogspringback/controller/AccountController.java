/*
 * @Author: 丑牛
 * @Date: 2021-10-20 09:21:09
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-10-20 11:10:06
 * @Description: file content
 */
package com.blog.blogspringback.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blog.blogspringback.common.dto.LoginDto;
import com.blog.blogspringback.common.lang.Result;
import com.blog.blogspringback.entity.User;
import com.blog.blogspringback.service.UserService;
import com.blog.blogspringback.util.JwtUtils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.server.HttpServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "1.0.0-SNAPSHOT", description = "用户管理", value = "用户管理")
public class AccountController {
    @Autowired
    UserService userService;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    @ApiOperation(value = "登录", notes = "账号管理")
    // @ApiImplicitParams({@ApiImplicitParam(name = "who", value = "用户名", dataType = DataType.STRING, paramType = ParamType.QUERY, defaultValue = "xxx")})
    public Result login(@Validated @RequestBody LoginDto loginDto, HttpServerResponse response ){
        User user = userService.getOne(new QueryWrapper<User>().eq("username", loginDto.getUserName()));
        Assert.notNull(user, "用户不存在");

        if (!user.getPassword().equals(SecureUtil.md5(loginDto.getPassword()))){
            return Result.fail("密码不正确");
        }

        String jwt = jwtUtils.generateToken(user.getId());

        response.setHeader("Authorization", jwt);
        response.setHeader("Access-control-Expose-Headers", "Authorization");
        return Result.success(MapUtil.builder().put("id", user.getId())
                                               .put("username", user.getUsername())
                                               .put("avatar", user.getAvatar())
                                               .put("email", user.getEmail())
                                               .map()
                                               );
    }

    @RequiresAuthentication
    @GetMapping("/logout")
    @ApiOperation(value = "退出", notes = "账号管理")
    public Result logout(){
        SecurityUtils.getSubject().logout();
        return Result.success(null);
    }

    
}
