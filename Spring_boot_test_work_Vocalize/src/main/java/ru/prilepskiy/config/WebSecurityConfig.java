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

/**
 * Created by VLADIMIR on 09.04.2018.
 *
 * Настройка конфигурации безопасности.
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Добавляем условия безопасности.
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // все запросы должны быть обработаны через фильтр
                .authorizeRequests()
                // пропустить
                .antMatchers("/all/**").permitAll()
                // все пользователи должны быть авторизованы
                .anyRequest().authenticated()
                .and()
                // форма залогиневания, разрешена для всех
                .formLogin().loginPage("/login").permitAll()
                .and()
                .httpBasic()
                .and()
                // разлогиниться могут все
                .logout().permitAll()
                .and()
                // авторизация с помощью ключа
                .csrf().disable();

//                .authorizeRequests()
//                .antMatchers("/").permitAll()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .defaultSuccessUrl("/users")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER")
//                .and()
//                .withUser("admin").password("password").roles("ADMIN");
//    }


    @Autowired
    private UserService userService;


    @Bean
    public PasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     *
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth
                    // данные хранятся в БД
                    .userDetailsService(this.userService)
                    // указать что в БД хранится зашифрованный пароль
                    .passwordEncoder(this.bcryptPasswordEncoder());

    }

}
