
/**
 * @Author: 丑牛
 * @Date: 2021-10-15 10:43:32
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-10-15 10:44:50
 * @Description: file content
 */
package spock.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import spock.example.demo.entity.UserDTO;

@Repository
public class UserDAO {
    public List<UserDTO> getUserInfo(){
        // 模拟用户中心服务接口调用
        List<UserDTO> users = new ArrayList<>();
        UserDTO user = new UserDTO();
        user.setId(1);
        user.setName("张三");
        user.setAge(28);
        user.setProvince("上海");
        users.add(user);
        return users;
    }

    public boolean insertUser(UserDTO userDTO){
        // 模拟数据库调用添加用户操作
        return true;
    }
    
}