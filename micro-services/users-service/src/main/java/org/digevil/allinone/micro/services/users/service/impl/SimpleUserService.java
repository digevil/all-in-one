package org.digevil.allinone.micro.services.users.service.impl;

import org.digevil.allinone.core.model.User;
import org.digevil.allinone.micro.services.users.repo.UserMapper;
import org.digevil.allinone.micro.services.users.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author: toni
 * @date: 2020/8/30 8:48 下午
 */
@Service
public class SimpleUserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public User findByUUID(String uuid) {
        return null;
    }

    @Override
    public UUID insert(User user) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(UUID id) {

    }
}
