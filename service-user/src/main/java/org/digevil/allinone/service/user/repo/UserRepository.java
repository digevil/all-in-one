package org.digevil.allinone.service.user.repo;

import org.digevil.allinone.service.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: toni
 * @date: 2020/9/5 11:16 上午
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
