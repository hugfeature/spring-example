package com.example.springweb.web;

import java.util.HashMap;
import java.util.Map;

import com.example.springweb.util.NeoProperties;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProPertiesTest {

    @Autowired
    private NeoProperties neoProperties;

    @Test
    public void getHello() throws Exception{
        System.out.println(neoProperties.getTitle());
        Assert.assertEquals(neoProperties.getTitle(), "test");
        Assert.assertEquals(neoProperties.getDescription(), "test");
    }

    @Test
    public void testMap() throws Exception{
        Map<String, Long> orderMinTime = new HashMap<String, Long>();
        long aa = orderMinTime.get("123");
    }
    
}
