
/*
 * @Author: 丑牛
 * @Date: 2021-09-16 09:11:00
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-09-16 09:44:55
 * @Description: file content
 */
package com.example.springwebthymeleaf.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String index(ModelMap map){
        map.addAttribute("message", "http://www.ityouknow.com");
        return "hello";
    }
    
}
