package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;




@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	 @Autowired
	 public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	 auth
	 .inMemoryAuthentication()
	 .withUser("admin").password("{noop}pass").roles("USER");
	 }
	 
	 /*
	  @Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/home").permitAll()
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/login")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll());

		return http.build();
	}
	  */

}
