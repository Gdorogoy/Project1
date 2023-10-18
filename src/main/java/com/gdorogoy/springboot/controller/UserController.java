package com.gdorogoy.springboot.controller;

import com.gdorogoy.springboot.entity.User;
import com.gdorogoy.springboot.service.userService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private userService UserService;

    @PostMapping("/create_user")
    public ResponseEntity<User> createUser(@RequestBody User user ){
        User savedUser=UserService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/get_id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User user=UserService.getUserById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("/get_all")
    public ResponseEntity<List<User>> getAll(){
        List<User> users= UserService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User user){
        user.setId(id);
        User userToUpdate=UserService.updateUser(user);
        return new ResponseEntity<>(userToUpdate,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        UserService.deleteUser(id);
        return new ResponseEntity<>("User has been deleted",HttpStatus.OK);
    }

}
