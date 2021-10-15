/*
 * @Author: 丑牛
 * @Date: 2021-10-15 11:27:44
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-10-15 11:38:29
 * @Description: 测试抽象类方法或者父类
 */
package spock.example.demo.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import spock.example.demo.dao.MoneyDAO;

public class SubService extends AbstractService {
    @Autowired
    MoneyDAO moneyDAO;
    public String doSomething() {
        String parent = super.parentMethod(); // 调用抽象类或父类方法
        if ("parent1".equals(parent)) {
            // 执行parent1分支逻辑
            return "sub1";
        }
        if ("parent2".equals(parent)) {
            // 执行parent2分支逻辑
            return "sub2";
        }
        if ("parent3".equals(parent)) {
            // 执行parent3分支逻辑
            return "sub3";
        }
        return "other";
    }

    public String doSomethingAndDao() {
        String parent = super.parentMethod(); // 调用抽象类或父类方法
        BigDecimal money = moneyDAO.getExchangeByCountry(parent);
        if ("parent1".equals(parent)) {
            return money + " CNY";
        }
        if ("parent2".equals(parent)) {
            return money + " USD";
        }
        if ("parent3".equals(parent)) {
            return money + " EUR";
        }
        return money.toString();
    }
}

