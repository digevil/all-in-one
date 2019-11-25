package org.digevil.allinone.classic.service;


import org.digevil.allinone.core.model.User;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    List<User> findAll();

    User findById(UUID id);

    UUID insert(User user);

    void update(User user);

    void delete(UUID id);
}
