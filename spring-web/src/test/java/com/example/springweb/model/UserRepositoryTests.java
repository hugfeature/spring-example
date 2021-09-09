package com.example.springweb.model;

import java.text.DateFormat;
import java.util.Date;

import com.example.springweb.repository.UserRepository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {
    @Autowired
    private UserRepository UserRepository;

    @Test
    public void test() throws Exception{
        Date date  = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

		UserRepository.save(new User("aa1", "aa@126.com", "aa", "aa123456",formattedDate));
		UserRepository.save(new User("bb2", "bb@126.com", "bb", "bb123456",formattedDate));
		UserRepository.save(new User("cc3", "cc@126.com", "cc", "cc123456",formattedDate));

        Assert.assertEquals("bb2", UserRepository.findByUserNameOrEmail("bb", "bb3@126.com").getNickName());
        UserRepository.delete(UserRepository.findByUserName("aa"));


    }

    
}
