package com.capstone.service;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
 
@Configuration
public class AppConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user1 = User.builder().
                username("sai")
                .password(passwordEncoder().encode("sai")).roles("ADMIN").
                build();
		UserDetails user2 = User.builder().
                username("aditya")
                .password(passwordEncoder().encode("aditya")).roles("EMPLOYEE").
                build();
		UserDetails user3 = User.builder().
                username("rahul@gmail.com")
                .password(passwordEncoder().encode("rahul")).roles("ADMIN").
                build();

 
		UserDetails user4 = User.builder().
                username("kohli@gmail.com")
                .password(passwordEncoder().encode("kohli")).roles("ADMIN").
                build();

        return new InMemoryUserDetailsManager(user1,user2,user3,user4);
    }
	@Bean
	public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
}
 
	
}