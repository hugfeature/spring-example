package com.example.springhello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.hutool.core.util.StrUtil;
	/**
	 * @author 丑牛
	 * Hello,World
	 * @param who 参数，非必要
	 * @return Hello ${who}
	 */
@RestController
public class HelloController {
    @GetMapping("/hello")
	public String sayHello(@RequestParam( required = false, name = "who") String who){
		if (StrUtil.isBlank(who)){
			who = "world";
		}
		return StrUtil.format("hello,{}", who);
	}
}
