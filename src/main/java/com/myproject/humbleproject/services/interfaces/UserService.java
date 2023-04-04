package com.myproject.humbleproject.services.interfaces;

import com.myproject.humbleproject.entities.Role;
import com.myproject.humbleproject.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UserService {

    User findUserById(Long l);
    User findUserByUsername(String username);
    Page<User> getAllUsers(int pageNumber, int pageSize);

    Set<Role> roles(String username);

}
