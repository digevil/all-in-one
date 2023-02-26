package org.digevil.allinone.service.user.service;

import org.digevil.allinone.service.user.exception.UserNotFound;
import org.digevil.allinone.service.user.model.User;
import org.digevil.allinone.service.user.repo.UserRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: toni
 * @date: 2020/9/5 5:50 下午
 */
@Service
public class UserService {
    /**
     * 这里的单引号不能少，否则会报错，被识别是一个对象
     */
    private static final String CACHE_KEY = "'user_'";
    private static final String DEMO_CACHE_NAME = "users";

    @Resource
    private UserRepository userRepository;

    /**
     * @return
     */
    public long countTotal() {
        return userRepository.count();
    }

    /**
     * 插入或者更新用户数据
     *
     * @param user
     * @return
     */
    @CachePut(value = DEMO_CACHE_NAME, key = CACHE_KEY + "+#user.getId()")
    public User save(User user) {
        return userRepository.save(user);
    }

    /**
     *
     * 根据用户 id 查找用户
     * @param id
     * @return
     */
    @Cacheable(value = DEMO_CACHE_NAME, key = "'user_'+#id")
    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(UserNotFound::new);
    }

    public List<User> findAll(User user) {
        Example<User> example = Example.of(user);
        return userRepository.findAll(example);
    }

    public Page<User> findPaged(Pageable pageable) {
       return userRepository.findAll(pageable);
    }

    @CacheEvict(value = DEMO_CACHE_NAME, key = CACHE_KEY + "+#id")
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

}
