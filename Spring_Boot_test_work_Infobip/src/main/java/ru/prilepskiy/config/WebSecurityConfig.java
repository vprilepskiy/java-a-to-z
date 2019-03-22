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
            .antMatchers("/*.html").permitAll()
            .antMatchers("/js/*.js").permitAll()
            .antMatchers("/auth/**").permitAll()
            .antMatchers("/api/*.skip").permitAll()
            // пропустить
//            .antMatchers("/api/**").permitAll() //временно
            // все пользователи должны быть авторизованы
            .anyRequest().authenticated()
            .and()
            // форма залогиневания, разрешена для всех
//            .formLogin().loginPage("/login").permitAll()
//            .and()
//            .httpBasic() // заюзаем custom registration
//            .and()
            // разлогиниться могут все
            .logout()
            // перенаправление после разрегистрации
            .logoutSuccessUrl("/loginPlease")
            .and()
            // авторизация с помощью ключа
            .csrf().disable();
    }


//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//            .inMemoryAuthentication()
//            .withUser("user").password("password").roles("USER")
//            .and()
//            .withUser("admin").password("password").roles("ADMIN");
//    }
}
