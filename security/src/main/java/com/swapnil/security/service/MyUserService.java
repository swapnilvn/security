package com.swapnil.security.service;

import com.swapnil.security.domain.MyUser;

import java.util.List;

public interface MyUserService {
    MyUser createUser(MyUser user);

    String deleteUser(Long id);

    MyUser getUserById(Long id);

    MyUser getUserByName(String name);

    List<MyUser> getAllUsers();
}
