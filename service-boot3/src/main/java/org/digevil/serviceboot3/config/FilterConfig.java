package org.digevil.serviceboot3.config;

import org.digevil.serviceboot3.config.filter.TidFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<TidFilter> traceIdFilterRegistration() {
        FilterRegistrationBean<TidFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new TidFilter());
        registration.addUrlPatterns("/*");
        registration.setName("tidFilter");
        registration.setOrder(1);
        return registration;
    }

}
