/*
 * @Author: 丑牛
 * @Date: 2021-10-18 11:53:43
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-10-20 17:32:42
 * @Description: 解决跨域问题,需注意升级版本后使用allowedOriginPatterns
 */
package com.blog.blogspringback.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    
    @Override
    public void addCorsMappings (CorsRegistry registry) {
        registry.addMapping("/**").allowedOriginPatterns("*").allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true).maxAge(3600).allowedHeaders("*");
    }
}
