/*
 * @Author: 丑牛
 * @Date: 2021-10-19 15:06:20
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-10-20 09:48:27
 * @Description: file content
 */
package com.blog.blogspringback.shiro;

import org.apache.shiro.authc.AuthenticationToken;

public class JwtToken implements AuthenticationToken{
    private String token;
    public JwtToken(String jwt){
        this.token = jwt;
    }
    @Override
    public Object getCredentials() {
        return token;
    }
    @Override
    public Object getPrincipal() {
        return token;
    }
    
    
}

