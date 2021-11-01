package com.test.demo.service

import spock.example.demo.dao.MoneyDAO
import spock.example.demo.dao.UserDAO
import spock.example.demo.entity.UserDTO
import spock.example.demo.service.UserService
import spock.lang.Specification

class UserServiceTest extends Specification{
    def userService = new UserService()
    def userDao = Mock(UserDAO)
    def moneyDao = Mock(MoneyDAO)

    void setup(){
        userService.userDao = userDao
        userService.moneyDao = moneyDao
    }

    def "GetUserById"() {
        given: "设置请求参数"
        def user1 = new UserDTO(id:1, name:"张三", province: "上海")
        def user2 = new UserDTO(id:2, name:"李四", province: "江苏")

        and: "mock掉接口返回的用户信息"
        userDao.getUserInfo() >> [user1, user2]

        when: "调用获取用户信息方法"
        def response = userService.getUserById(1)

        then: "验证返回结果是否符合预期值"
        with(response) {
            name == "张三"
            abbreviation == "沪"
            postCode == 200000
        }
    }
}
