/*
 * @Author: 丑牛
 * @Date: 2021-09-16 15:10:54
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-09-17 10:30:56
 * @Description: file content
 */
package com.example.springjpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private Long userId;
    private String provices;
    private String city;
    private String street;
    

}
