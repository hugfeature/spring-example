/*
 * @Author: 丑牛
 * @Date: 2021-09-17 10:38:00
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-09-17 11:03:20
 * @Description: file content
 */
package com.example.springjpa.param;

import lombok.Data;

@Data
public class UserDetailParam {
    private String userId;
    private Integer minAge;
    private Integer maxAge;
    private String realName;
    private String introduction;
    private String city;
    public String getIntroduction() {
        return introduction;
    }
    public String getRealName() {
        return realName;
    }
    public Object getMaxAge() {
        return maxAge;
    }
    
}
