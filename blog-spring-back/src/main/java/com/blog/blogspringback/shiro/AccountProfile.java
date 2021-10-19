/*
 * @Author: 丑牛
 * @Date: 2021-10-18 14:53:22
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-10-18 14:54:36
 * @Description: file content
 */
package com.blog.blogspringback.shiro;

import lombok.Data;

@Data
public class AccountProfile {
    private Long id;
    private String username;
    private String avatar;
    private String email;
}

