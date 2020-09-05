package org.digevil.allinone.micro.services.users.service;


import org.digevil.allinone.core.model.User;

import java.util.List;
import java.util.UUID;

/**
 * @author toni
 */
public interface IUserService {
    List<User> findAll();

    User findById(int id);

    User findByUUID(String uuid);

    UUID insert(User user);

    void update(User user);

    void delete(UUID id);
}
