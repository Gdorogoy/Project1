package com.gdorogoy.springboot.service.Impl;

import com.gdorogoy.springboot.entity.User;
import com.gdorogoy.springboot.repository.userRepository;
import com.gdorogoy.springboot.service.userService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements userService {

    private userRepository UserRepository;


    @Override
    public User createUser(User user) {
        return UserRepository.save((user));
    }

    @Override
    public User getUserById(Long userid) {
        Optional<User> optionalUser =UserRepository.findById(userid);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUsers() {
        return UserRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User userExist=UserRepository.findById(user.getId()).get();
        userExist.setFirstName(user.getFirstName());
        userExist.setLastName(user.getLastName());
        userExist.setEmail(user.getEmail());
        User userUpdated=UserRepository.save(userExist);
        return userUpdated;
    }

    @Override
    public void deleteUser(Long id) {
        UserRepository.deleteById(id);
    }
}
