package org.digevil.allinone.classic.service.impl;

import com.github.pagehelper.PageHelper;
import org.digevil.allinone.classic.repo.UserMapper;
import org.digevil.allinone.classic.service.IUserService;
import org.digevil.allinone.core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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
    public Page<User> findAllPaged(Pageable pageable) {
        /**
         * 分页
         */
        com.github.pagehelper.Page pages = PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        return new PageImpl<>(userMapper.findAllPaged(), pageable, pages.getTotal());
    }

    @Override
    public User findById(UUID id) {
        return userMapper.findById(id);
    }

    @Override
    public Page<User> findByExample(User example, Pageable pageable) {
        com.github.pagehelper.Page pages = PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        return new PageImpl<>(userMapper.findByExample(example), pageable, pages.getTotal());
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
