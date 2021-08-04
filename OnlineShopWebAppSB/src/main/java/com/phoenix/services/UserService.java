package com.phoenix.services;

import java.util.List;

import com.phoenix.entities.User;
import com.phoenix.exceptions.UserNotFoundException;

public interface UserService {
	User findByUsername(String username) throws UserNotFoundException;
    List<User> findAllUsers();
    void add(User user);
    void edit(User user);
    void remove(User user);
    
}
