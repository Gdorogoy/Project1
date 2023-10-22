package com.gdorogoy.springboot.service.Impl;

import com.gdorogoy.springboot.dto.UserDTO;
import com.gdorogoy.springboot.entity.User;
import com.gdorogoy.springboot.exception.EmailAlreadyExistException;
import com.gdorogoy.springboot.exception.ResourceNotFoundException;
import com.gdorogoy.springboot.mapper.UserMapper;
import com.gdorogoy.springboot.repository.UserRepository;
import com.gdorogoy.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDto) {

        // Convert UserDto into User JPA Entity
        //User user = UserMapper.mapToUser(userDto);
        Optional<User> optionalUser=userRepository.findByEmail(userDto.getEmail());

        if (optionalUser.isPresent()){
            throw new EmailAlreadyExistException("Email Already Exist For User");
        }
        User user=modelMapper.map(userDto,User.class);
        User savedUser = userRepository.save(user);

        // Convert User JPA entity to UserDto
        //UserDTO savedUserDto = UserMapper.mapToUserDto(savedUser);
        UserDTO savedUserDto=modelMapper.map(user,UserDTO.class);
        return savedUserDto;
    }

    @Override
    public UserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        return modelMapper.map(user, UserDTO.class);
    }


    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(UserDTO user) {
        User existingUser = userRepository.findById(user.getId()).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", user.getId()));
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
        return modelMapper.map(updatedUser,UserDTO.class);
    }

    @Override
    public void deleteUser(Long userId) {
        User existingUser = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userId));
        userRepository.deleteById(userId);
    }
}
