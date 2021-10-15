/*
 * @Author: 丑牛
 * @Date: 2021-10-15 09:03:02
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-10-15 09:08:04
 * @Description: file content
 */
package spock.example.demo.mapper;

import org.springframework.stereotype.Component;

import spock.example.demo.entity.UserDTO;
import spock.example.demo.entity.UserVO;

@Component
public class UserMapper {
    public UserDTO toUserDTo(UserVO userVO){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userVO.getId());
        userDTO.setName(userVO.getName());
        userDTO.setSex(userVO.getSex());
        userDTO.setCurrency("RMB");
        return userDTO;
    }
    
}
