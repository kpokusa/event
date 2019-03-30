package com.eventcalendar.event.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfigEvent extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) {
//        try {
//            auth.inMemoryAuthentication().withUser("rafal").password("{noop}rafal").roles("USER")
//                    .and().withUser("admin").password("{noop}password").roles("USER", "ADMIN");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsServiceBean())
                .passwordEncoder(passwordEncoder());
    }

    //https://docs.spring.io/spring/docs/3.0.6.RELEASE_to_3.1.0.BUILD-SNAPSHOT/3.0.6.RELEASE/org/springframework/util/AntPathMatcher.html
    //https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .authorizeRequests()
                .antMatchers(
                        "/h2-console/**",
                        "/adduser/**",
                        "/",
                        "/js/**",
                        "/css/**",
                        "/img/**",
                        "/webjars/**").permitAll()
                //.antMatchers("/procregister/**").hasRole("USER")
                .antMatchers("/procgerister/**").hasAnyRole("DBADMIN", "USER")
                //.antMatchers("/dp/user").hasAnyRole("DBADMIN","USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll();

        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
    }
}