/*
 * @Author: 丑牛
 * @Date: 2021-09-26 19:52:23
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-09-28 20:18:51
 * @Description: 登录缓存层
 */
package com.blog.blogspringback.common.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginDto implements Serializable {

    @NotBlank(message = "用户名不能为空")
    private String userName;

    @NotBlank(message = "密码不能为空")
    private String password;

}
