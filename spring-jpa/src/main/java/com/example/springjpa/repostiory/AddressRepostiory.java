
/*
 * @Author: 丑牛
 * @Date: 2021-09-17 10:49:52
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-09-17 10:49:53
 * @Description: file content
 */
package com.example.springjpa.repostiory;

import com.example.springjpa.model.Address;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepostiory extends JpaRepository<Address, Long> {
    
}
