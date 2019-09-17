package com.breadcrumbdata.auth_server.controller;

import com.breadcrumbdata.auth_server.dataobject.User;
import com.breadcrumbdata.auth_server.exception.UsernameNotMatchException;
import com.breadcrumbdata.auth_server.repository.UserRepository;
import com.breadcrumbdata.auth_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public String getUser(@RequestParam String username, OAuth2Authentication oAuth2Authentication) throws UsernameNotMatchException{
        if(username.equals(oAuth2Authentication.getName())){
            User user = userService.findOneByUsername(username);
            return user.getId().toString();
        }else{
            throw new UsernameNotMatchException(oAuth2Authentication.getName(), username);
        }
    }
}
