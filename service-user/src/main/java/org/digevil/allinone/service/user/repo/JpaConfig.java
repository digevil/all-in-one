package org.digevil.allinone.service.user.repo;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author: toni
 * @date: 2020/9/5 11:34 上午
 */
@EnableJpaRepositories
@EntityScan("org.digevil.allinone.service.user.model")
@Configuration
public class JpaConfig {
}
