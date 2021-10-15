/*
 * @Author: 丑牛
 * @Date: 2021-10-15 10:56:00
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-10-15 10:56:01
 * @Description: file content
 */

package spock.example.demo.util;

import org.springframework.stereotype.Component;


@Component
public class OrderConfig {
      /**
     * 是否展示订单创建时间
     * @return
     */
    public boolean isShowOrderTime(){
        // 调用统一配置中心CMS获取配置
        return true;
    }  
}
