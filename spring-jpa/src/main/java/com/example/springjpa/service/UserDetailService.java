
/*
 * @Author: 丑牛
 * @Date: 2021-09-17 10:42:57
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-09-17 10:45:52
 * @Description: file content
 */
package com.example.springjpa.service;

import com.example.springjpa.model.UserDetail;
import com.example.springjpa.param.UserDetailParam;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserDetailService {
    public Page<UserDetail> findByCondition(UserDetailParam detailParam, Pageable pageable);
    
}