package com.twentyfour.service;

import java.util.List;

import com.twentyfour.model.User;
import com.twentyfour.model.enums.Role;

public interface UserService {

    public User getUser(Long id);
    public List<User> getUsers();
    public Long addUser(String userName, String firstName, String lastName, Role role);
}
