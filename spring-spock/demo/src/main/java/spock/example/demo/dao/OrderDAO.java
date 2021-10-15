
/*
 * @Author: 丑牛
 * @Date: 2021-10-15 10:33:38
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-10-15 10:44:18
 * @Description: file content
 */
package spock.example.demo.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import spock.example.demo.entity.OrderDTO;
import spock.example.demo.entity.UserDTO;

@Repository
public class OrderDAO {
    
    public List<OrderDTO> getOrderByUser(UserDTO user){
        // 模拟订单服务接口调用
        List<OrderDTO> orders = new ArrayList<>();
        OrderDTO order = new OrderDTO();
        order.setOrderNum("D3412345");
        order.setAmount(BigDecimal.valueOf(1000));
        orders.add(order);
        return orders;
    }

    
}
