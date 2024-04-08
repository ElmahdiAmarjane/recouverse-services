package com.recouvrex.process.service.impl;

import com.recouvrex.process.model.User;
import com.recouvrex.process.repository.UserRepository;
import com.recouvrex.process.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public List<User> findByManager(Long managerId) {
        User manager = userRepository.findById(managerId).orElse(null);
        if(manager!=null) {
            return null; //userRepository.findByManager(manager);
        }else{
            return Collections.emptyList();
        }

    }
}
