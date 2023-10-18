package com.gdorogoy.springboot.service;

import com.gdorogoy.springboot.entity.User;

import java.util.List;

public interface userService {
    User createUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Long id);
}
