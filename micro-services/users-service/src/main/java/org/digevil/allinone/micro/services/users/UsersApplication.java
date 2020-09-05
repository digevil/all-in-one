package org.digevil.allinone.micro.services.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author: toni
 * @date: 2020/8/30 8:14 下午
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class UsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class, args);
    }

}
