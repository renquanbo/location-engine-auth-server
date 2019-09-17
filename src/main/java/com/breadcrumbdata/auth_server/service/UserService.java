package com.breadcrumbdata.auth_server.service;

import com.breadcrumbdata.auth_server.dataobject.User;

public interface UserService {
    User create(String username,String password, String email);
    User findOneByUsername(String username);
}
