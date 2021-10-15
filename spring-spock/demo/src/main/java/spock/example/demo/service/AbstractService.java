
/*
 * @Author: 丑牛
 * @Date: 2021-10-15 10:45:53
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-10-15 10:45:54
 * @Description: file content
 */
package spock.example.demo.service;

public abstract class AbstractService {
    String parentMethod() {
        // 发起接口调用或数据库操作
        return "parentMethod value";
    }

}
