package com.gdorogoy.springboot.service;

import com.gdorogoy.springboot.dto.UserDTO;
import com.gdorogoy.springboot.entity.User;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO user);

    UserDTO getUserById(Long userId);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(UserDTO user);

    void deleteUser(Long userId);
}
