
/*
 * @Author: 丑牛
 * @Date: 2021-10-11 19:47:04
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-10-11 19:47:04
 * @Description: file content
 */
package spock.example.demo.entity;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class OrderVO {

    private String orderNum;
    private BigDecimal amount;
    private String createTime;
    private String orderDesc;
    /**
     * 1:APP, 2:H5, 3:PC
     */
    private int type;
}