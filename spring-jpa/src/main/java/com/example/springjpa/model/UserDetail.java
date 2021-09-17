
/*
 * @Author: 丑牛
 * @Date: 2021-09-17 10:20:44
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-09-17 11:10:30
 * @Description: file content
 */

package com.example.springjpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class UserDetail {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private Long userId;
    private Integer age;
    private String realName;
    private String status;
    private String hobby;
    private String introduction;
    private String lastLoginIp;

    @Override
    public String toString() {
        return "UserDetail{" + "id=" + id + ", userId=" + userId + ", age=" + age + ", realName='" + realName + '\''
                + ", status='" + status + '\'' + ", hobby='" + hobby + '\'' + ", introduction='" + introduction + '\''
                + ", lastLoginIp='" + lastLoginIp + '\'' + '}';
    }

}
