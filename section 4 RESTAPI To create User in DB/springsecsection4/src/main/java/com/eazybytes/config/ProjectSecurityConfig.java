package com.eazybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) {

        http.csrf((csrfconfig)->csrfconfig.disable());
        http.authorizeHttpRequests((requests)->
                        requests.
                                requestMatchers("/myAccount","/myBalance","/myCards","/myLoans").authenticated()
                                .requestMatchers("/notices","/contact","/register").permitAll());
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }


    //The below has been commented as we are using the custom UserDetailsService implementing it using the EazyBankUserDetailsService
//    @Bean
// public UserDetailsService userDetailsService(DataSource dataSource)
//    {
//
//        return new JdbcUserDetailsManager(dataSource);
//    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public CompromisedPasswordChecker compromisedPasswordChecker()
    {
        return new HaveIBeenPwnedRestApiPasswordChecker();
    }


}
