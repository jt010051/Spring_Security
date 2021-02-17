package com.jt.springsecurityproject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
public class Config extends WebSecurityConfigurerAdapter{
	private final PasswordEncoder passwordEncoder;
	@Autowired
		public Config(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
		@Override
		protected void configure (HttpSecurity http) throws Exception{
			http 
			.authorizeRequests()
			.antMatchers("/", "index", "/csss/*", "/js/*","login","/html/*").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
			
		}
		@Override
		@Bean
		protected UserDetailsService userDetailsService() {
			UserDetails jbonduser =User.builder()
			.username("jbond")
			.password(passwordEncoder.encode("password"))
			.roles("STANDARD")
			.build();
			
			return new InMemoryUserDetailsManager(jbonduser);
				
				}
			}
		

