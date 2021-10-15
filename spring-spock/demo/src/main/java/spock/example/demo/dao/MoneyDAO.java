
/*
 * @Author: 丑牛
 * @Date: 2021-10-15 09:09:05
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-10-15 10:32:49
 * @Description: file content
 */
package spock.example.demo.dao;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

@Repository
public class MoneyDAO {
    public BigDecimal getExchangeByCountry(String country){
        // 模拟调用汇率接口获取最新的汇率
        return BigDecimal.ONE;
    }

    public BigDecimal getExchangeByCurrency(String currency){
        // 模拟调用汇率接口获取最新的汇率
        return BigDecimal.ONE;
    }
    
}
