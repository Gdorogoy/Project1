package com.gdorogoy.springboot.mapper;

import com.gdorogoy.springboot.dto.UserDTO;
import com.gdorogoy.springboot.entity.User;

public class UserMapper {

    //Convert user JPA entity into UserDto.
    public static UserDTO mapToUserDto(User user){
        UserDTO userDTO=new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDTO;
    }

    //Convert userDTO into JPA entity.
    public static User mapToUser(UserDTO userDTO){
        User user=new User(
                userDTO.getId(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail()
        );
        return user;
    }
}
