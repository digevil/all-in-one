package org.digevil.allinone.classic.service.impl;

import org.digevil.allinone.classic.service.IUserService;
import org.digevil.allinone.core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CachedUserService implements IUserService {

    @Autowired
    @Qualifier(value = "simpleUserService")
    private IUserService userService;

    @Override
    public List<User> findAll() {
        //add cache logic
        return userService.findAll();
    }

    @Override
    public Page<User> findAllPaged(Pageable pageable) {
        // add cache logic
        return userService.findAllPaged(pageable);
    }

    @Override
    public User findById(UUID id) {
        // add cache logic
        return userService.findById(id);
    }

    @Override
    public Page<User> findByExample(User example, Pageable pageable) {
        return userService.findByExample(example, pageable);
    }

    @Override
    public UUID insert(User user) {
        return userService.insert(user);
    }

    @Override
    public void update(User user) {
        userService.update(user);
    }

    @Override
    public void delete(UUID id) {
        userService.delete(id);
    }
}
