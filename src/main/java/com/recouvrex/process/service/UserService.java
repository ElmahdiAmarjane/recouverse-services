package com.recouvrex.process.service;

import com.recouvrex.process.model.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public User save(User user);

    List<User> findByManager(Long managerId);


}
