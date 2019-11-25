package org.digevil.allinone.classic.service.impl;

import org.digevil.allinone.classic.service.IUserService;
import org.digevil.allinone.core.model.User;
import org.digevil.allinone.classic.repo.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SimpleUserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findById(UUID id) {
        return userMapper.findById(id);
    }

    @Override
    public UUID insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void delete(UUID id) {
        userMapper.delete(id);
    }


}
