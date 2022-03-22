package com.example.springboot.dao;

import com.example.springboot.model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    void deleteUser(long id);

    void updateUser(User user);

    List<User> getAllUsers();

    User getUserById(long id);
}
