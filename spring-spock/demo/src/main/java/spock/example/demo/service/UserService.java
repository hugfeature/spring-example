/*
 * @Author: 丑牛
 * @Date: 2021-10-15 10:58:48
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-10-15 11:22:58
 * @Description: file content
 */
package spock.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spock.example.demo.dao.MoneyDAO;
import spock.example.demo.dao.UserDAO;
import spock.example.demo.entity.UserDTO;
import spock.example.demo.entity.UserVO;
import spock.example.demo.util.IDNumberUtils;
import spock.example.demo.util.LogUtils;

@Service
public class UserService {
    @Autowired
    public
    UserDAO userDao;

    @Autowired
    public
    MoneyDAO moneyDao;

    public UserVO getUserById(int uid){
        List<UserDTO> users =  userDao.getUserInfo();
        UserDTO userDTO = users.stream().filter(u -> u.getId() == uid).findFirst().orElse(null);
        UserVO userVO = new UserVO();
        if (null == userDTO) {
            return userVO;
        }
        userVO.setId(userDTO.getId());
        userVO.setName(userDTO.getName());
        userVO.setSex(userDTO.getSex());
        userVO.setAge(userDTO.getAge());
        // 显示邮编
        if("上海".equals(userDTO.getProvince())){
            userVO.setAbbreviation("沪");
            userVO.setPostCode(200000);
        }
        if("北京".equals(userDTO.getProvince())){
            userVO.setAbbreviation("京");
            userVO.setPostCode(100000);
        }
        // 手机号处理
        if(null != userDTO.getTelephone() && !"".equals(userDTO.getTelephone())){
            userVO.setTelephone(userDTO.getTelephone().substring(0,3)+"****"+userDTO.getTelephone().substring(7));
        }

        return userVO;
    }

    public boolean addUser(UserVO userVO){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userVO.getId());
        userDTO.setName(userVO.getName());
        userDTO.setSex(userVO.getSex());
        return userDao.insertUser(userDTO);
    }

    public UserVO getUserByIdStatic(int uid){
        List<UserDTO> users = userDao.getUserInfo();
        UserDTO userDTO = users.stream().filter(u -> u.getId() == uid).findFirst().orElse(null);
        UserVO userVO = new UserVO();
        if(null == userDTO){
            return userVO;
        }
        userVO.setId(userDTO.getId());
        userVO.setName(userDTO.getName());
        userVO.setSex(userDTO.getSex());
        if("上海".equals(userDTO.getProvince())){
            userVO.setAbbreviation("沪");
            userVO.setPostCode(200000);
        }
        if("北京".equals(userDTO.getProvince())){
            userVO.setAbbreviation("京");
            userVO.setPostCode(100000);
        }
        if(null != userDTO.getTelephone() && !"".equals(userDTO.getTelephone())){
            userVO.setTelephone(userDTO.getTelephone().substring(0,3)+"****"+userDTO.getTelephone().substring(7));
        }
        // 静态方法调用 身份证工具类
        Map<String, String> idMap = IDNumberUtils.getBirAgeSex(userDTO.getIdNo());
        userVO.setAge(idMap.get("age")!=null ? Integer.parseInt(idMap.get("age")) : 0);
        // 静态方法调用 记录日志
        LogUtils.info("response user:", userVO.toString());
        return userVO;
    }
    
    
}
