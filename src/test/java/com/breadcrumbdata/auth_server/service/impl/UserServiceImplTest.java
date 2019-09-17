package com.breadcrumbdata.auth_server.service.impl;

import com.breadcrumbdata.auth_server.dataobject.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @Autowired
    UserServiceImpl userService;

//    @Test
//    public void create() throws Exception {
//        //User user = userService.create("julia", "1212", "julia12@gmail.com");
//        User user = userService.create("robert", "13134", "robert13@gmail.com");
//        System.out.println(user.toString());
//    }

    @Test
    public void findOneByUsername() throws Exception {
        User user = userService.findOneByUsername("robert");
        System.out.println(user.toString());
    }

}