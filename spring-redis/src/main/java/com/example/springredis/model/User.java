
/*
 * @Author: 丑牛
 * @Date: 2021-09-14 10:46:34
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-09-14 15:29:02
 * @Description: file content
 */
package com.example.springredis.model;

import java.io.Serializable;

import lombok.Data;

@Data
// 使用lomok的@data时要引入序列化，否则会报错
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String userName;
	private String password;
	private String email;
	private String nickname;
	private String regTime;

    public User() {
        super(); //调用父类构造方法
    }
    public User(String email, String nickname, String password, String userName, String regTime) {
		super();
		this.email = email;
		this.nickname = nickname;
		this.password = password;
		this.userName = userName;
		this.regTime = regTime;
	}
    

    // 重写toString
    @Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", nickname='" + nickname + '\'' +
				", regTime='" + regTime + '\'' +
				'}';
	}
}
