//package com.github.MaryHrisanfova.BibliographySystem.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@EnableWebSecurity
//@Configuration
//@ComponentScan(basePackages = {"com.github.MaryHrisanfova.BibliographySystem"})
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    InMemoryUserDetailsManager inMemoryUserDetailsManager ;
//
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(inMemoryUserDetailsManager)
//                .passwordEncoder(getShaPasswordEncoder());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http
//                .httpBasic()
//                .and()
//                .antMatcher("/**")
//                .authorizeRequests()
//                .anyRequest().permitAll()
//                .antMatchers("/books/layout").hasAnyRole()
//                .antMatchers("/login**").permitAll()
//                .antMatchers("/login/**").permitAll()
//                .and()
//                .exceptionHandling()
//                .and()
//                .csrf().disable()
//                .formLogin().loginPage("/login/layout");
//    }
//    @Bean
//    public ShaPasswordEncoder getShaPasswordEncoder() {
//        return new ShaPasswordEncoder();
//    }
//}
