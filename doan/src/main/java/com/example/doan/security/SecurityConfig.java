package com.example.doan.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }
    //@Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails xb = User.builder().username("xuanbac")
//                                    .password("{noop}123")
//                                    .roles("EMPLOYEE","ADMIN")
//                                    .build();
//        return new InMemoryUserDetailsManager(xb);
//    }
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer->configurer
                        .requestMatchers("/admin/**").hasAnyRole("ADMIN", "MANAGER")
                        .anyRequest().permitAll())
                .formLogin(form->form
                        .loginPage("/login")
                        .loginProcessingUrl("/authenticateTheUser").permitAll())
                .logout(logout->logout.permitAll());
        return http.build();
    }
}