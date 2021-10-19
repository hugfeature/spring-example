/*
 * @Author: 丑牛
 * @Date: 2021-10-19 18:15:46
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-10-19 18:17:41
 * @Description: file content
 */
package com.blog.blogspringback.util;

import com.blog.blogspringback.shiro.AccountProfile;

import org.apache.shiro.SecurityUtils;

public class ShiroUtil {
    public static AccountProfile getProfile(){
        return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    }
}

