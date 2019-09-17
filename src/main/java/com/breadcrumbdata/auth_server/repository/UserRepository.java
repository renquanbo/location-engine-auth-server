package com.breadcrumbdata.auth_server.repository;

import com.breadcrumbdata.auth_server.dataobject.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
    User findByUsername(String username);
}
