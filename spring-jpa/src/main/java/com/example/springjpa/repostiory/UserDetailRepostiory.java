
/*
 * @Author: 丑牛
 * @Date: 2021-09-17 10:51:07
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-09-17 10:54:18
 * @Description: file content
 */
package com.example.springjpa.repostiory;

import java.util.List;

import com.example.springjpa.model.UserDetail;
import com.example.springjpa.model.UserInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface UserDetailRepostiory extends JpaSpecificationExecutor<UserDetail>,JpaRepository<UserDetail, Long>{
    UserDetail findByHobby(String hobby);

    @Query(
        "select u.userName as userName, u.email as email, d.introduction as introduction , d.hobby as hobby from User u , UserDetail d " +
        "where u.id=d.userId  and  d.hobby = ?1 " 
    )
    List<UserInfo> findUserInfo(String hobby);
    
}