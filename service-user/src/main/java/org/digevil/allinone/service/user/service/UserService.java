package org.digevil.allinone.service.user.service;

import org.digevil.allinone.service.user.exception.UserNotFound;
import org.digevil.allinone.service.user.model.User;
import org.digevil.allinone.service.user.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author: toni
 * @date: 2020/9/5 5:50 下午
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public long countTotal() {
        return userRepository.count();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(UserNotFound::new);
    }

    public List<User> findAll(User user) {
        Example<User> example = Example.of(user);
        return userRepository.findAll(example);
    }

    public void delete(Integer userId) {
        userRepository.deleteById(userId);
    }

}
