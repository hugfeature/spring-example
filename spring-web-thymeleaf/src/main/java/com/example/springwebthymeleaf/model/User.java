/*
 * @Author: 丑牛
 * @Date: 2021-09-15 19:59:50
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-09-15 20:03:06
 * @Description: file content
 */
package com.example.springwebthymeleaf.model;

import lombok.Data;

@Data
public class User {
    private String name;
    private int age;
    private String pass;
    
    public User(String name, int age, String pass){
        this.name = name;
        this.age = age;
        this.pass = pass;
    }

    @Override
    public String toString() {
        return ("name=" + this.name + ",age=" + this.age + ",pass=" + this.pass);
    }
     
}