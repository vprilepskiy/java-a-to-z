package ru.prilepskiy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // все запросы должны быть обработаны через фильтр
            .authorizeRequests()
            // пропустить
            .antMatchers("/api/*.skip").permitAll()
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
}
