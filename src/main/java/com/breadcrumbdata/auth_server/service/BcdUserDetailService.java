package com.breadcrumbdata.auth_server.service;

import com.breadcrumbdata.auth_server.dataobject.User;
import com.breadcrumbdata.auth_server.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("bcdUserDetailService")
public class BcdUserDetailService implements UserDetailsService{

    @Autowired
    UserServiceImpl userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findOneByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException(username);
        }
        //System.out.println(user.toString());
        return new BcdUserPrincipal(user);
    }
}
