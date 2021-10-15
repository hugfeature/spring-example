
/*
 * @Author: 丑牛
 * @Date: 2021-10-11 20:00:26
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-10-11 20:00:27
 * @Description: file content
 */
package spock.example.demo.entity;

import java.util.List;

import lombok.Data;

@Data
public class UserVO {
    private int id;
    private String name;
    private int age;
    private String sex;
    private int postCode; // 邮编
    private String abbreviation; // 省份简称
    private String country; // 国家
    private String telephone;
    private List<OrderVO> userOrders; // 用户订单
}
