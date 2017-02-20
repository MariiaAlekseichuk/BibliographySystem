package com.github.MaryHrisanfova.BibliographySystem.config;

import com.github.MaryHrisanfova.BibliographySystem.utilities.CustomAccessDeniedHandler;
import com.github.MaryHrisanfova.BibliographySystem.utilities.CustomBasicAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
@ComponentScan(basePackages = {"com.github.MaryHrisanfova.BibliographySystem"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    InMemoryUserDetailsManager inMemoryUserDetailsManager;

    @Autowired
    CustomBasicAuthenticationEntryPoint entryPoint;

    @Autowired
    CustomAccessDeniedHandler deniedHandler;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(inMemoryUserDetailsManager)
                .passwordEncoder(getShaPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.userDetailsService(inMemoryUserDetailsManager)
                .httpBasic()
                .authenticationEntryPoint(entryPoint)
                .and()
                .authorizeRequests()
                .antMatchers("/books/*").hasAuthority("USER")
                .antMatchers("/book/*").hasAuthority("USER")
                .and()
                .exceptionHandling()
                .accessDeniedHandler(deniedHandler)
                .and()
                .csrf().disable();
    }

    @Bean
    public ShaPasswordEncoder getShaPasswordEncoder() {
        return new ShaPasswordEncoder();
    }
}
