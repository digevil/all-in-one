package org.digevil.allinone.core;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: toni
 * @date: 2020/9/5 11:46 上午
 */
@Configuration
//@ComponentScan("org.digevil.allinone.core.**")
@EntityScan("org.digevil.allinone.core.model")
public class CoreConfig {
}
