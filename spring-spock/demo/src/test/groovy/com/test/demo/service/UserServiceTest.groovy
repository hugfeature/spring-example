package com.test.demo.service

import spock.lang.Specification
import spock.lang.Unroll

class UserServiceTest extends Specification{ 
    def userService = new userService();
    def userDao = Mock(UserDao);


}