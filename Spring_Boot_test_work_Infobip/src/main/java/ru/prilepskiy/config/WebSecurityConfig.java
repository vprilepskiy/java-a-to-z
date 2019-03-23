package ru.prilepskiy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.prilepskiy.service.UserService;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // все запросы должны быть обработаны через фильтр
            .authorizeRequests()
            // пропустить
            .antMatchers("/account").permitAll()
            // все пользователи должны быть авторизованы
            .anyRequest().authenticated()
            .and()
            .httpBasic()
            .and()
            // разлогиниться могут все
            .logout()
            .and()
            .csrf().disable();
    }

    @Bean
    public PasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UserService userService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                // данные хранятся в БД
                .userDetailsService(this.userService)
                // указать что в БД хранится зашифрованный пароль
                .passwordEncoder(this.bcryptPasswordEncoder());

    }
}
