package com.gdorogoy.springboot.controller;

import com.gdorogoy.springboot.dto.UserDTO;
import com.gdorogoy.springboot.entity.User;
import com.gdorogoy.springboot.exception.ErrorDetails;
import com.gdorogoy.springboot.exception.ResourceNotFoundException;
import com.gdorogoy.springboot.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    // build create User REST API
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO user){
        UserDTO savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // build get user by id REST API
    // http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long userId){
        UserDTO user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Build Get All Users REST API
    // http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Build Update User REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/users/1
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") Long userId,
                                              @RequestBody UserDTO user){
        user.setId(userId);
        UserDTO updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted", HttpStatus.OK);
    }


}
