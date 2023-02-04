package com.nf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages ={"com.nf.config"})
public class SecurityConfig {


    @Autowired
   public void configure(AuthenticationManagerBuilder auth) throws Exception {

       auth.inMemoryAuthentication()
               .withUser("mehedi")
               .password("{noop}1234")
               .roles("ADMIN");
   }

   @Bean
   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.
                authorizeHttpRequests((authz)->authz
                        .anyRequest().authenticated()).
                httpBasic(Customizer.withDefaults());

        return http.build();
   }
}
