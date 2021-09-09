package com.example.springweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;


@Entity
@Data
public class User {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String nickName;

    @Column(nullable = false)
    private String regTime;
	public User() {
		super();
	}
	public User(String nickName,String email,String userName,  String passWord, String regTime) {
		super();
		this.email = email;
		this.nickName = nickName;
		this.password = passWord;
		this.userName = userName;
		this.regTime = regTime;
	}
    public Object getNickName() {
        return nickName;
    }

}
