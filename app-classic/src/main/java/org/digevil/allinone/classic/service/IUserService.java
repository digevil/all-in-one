package org.digevil.allinone.classic.service;


import org.digevil.allinone.core.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    List<User> findAll();

    Page<User> findAllPaged(Pageable pageable);

    User findById(UUID id);

    Page<User> findByExample(User example, Pageable pageable);

    UUID insert(User user);

    void update(User user);

    void delete(UUID id);
}
