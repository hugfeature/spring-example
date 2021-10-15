
/*
 * @Author: 丑牛
 * @Date: 2021-10-11 19:49:01
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-10-11 20:01:17
 * @Description: file content
 */
package spock.example.demo.entity;

import java.util.List;

import lombok.Data;

@Data
public class UserDTO {
    private int id;
    private String name;
    private int age;
    private String sex;
    private String province;
    private String telephone;
    private String idNo;
    private String currency; // 币种
    private List<OrderVO> userOrders; // 用户订单
    
}
