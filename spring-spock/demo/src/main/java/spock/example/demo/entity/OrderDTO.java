
/*
 * @Author: 丑牛
 * @Date: 2021-10-11 19:45:22
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-10-11 19:46:50
 * @Description: file content
 */
package spock.example.demo.entity;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class OrderDTO {
    private String orderNum;
    private BigDecimal amount;
    private String createTime;
    private int type;
}
