/*
 * @Author: 丑牛
 * @Date: 2021-10-18 13:41:03
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-10-18 14:13:55
 * @Description: mybatis plus配置
 */
package com.blog.blogspringback.config;

import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan("com.blog.blogspringback.mapper")
public class MybatisPlusConfig {
    @Bean
    public PaginationInnerInterceptor paginationInterceptor(){
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
        return paginationInnerInterceptor;
    }
}

