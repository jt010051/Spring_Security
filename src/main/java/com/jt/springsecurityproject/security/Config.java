package com.jt.springsecurityproject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;





@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class Config extends WebSecurityConfigurerAdapter{
	private final PasswordEncoder passwordEncoder;
	@Autowired
	public Config(PasswordEncoder passwordEncoder) {
		super();
		this.passwordEncoder = passwordEncoder;
		
	}
		@Override
		protected void configure (HttpSecurity http) throws Exception{
			http 
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/", "index", "/csss/*", "/js/*","/jsp/*").permitAll()
			.antMatchers("/api/**").hasRole(Role.STANDARD.name())
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.passwordParameter("password")
				.usernameParameter("username")
				.defaultSuccessUrl("/redirect", true)

			.and()
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
				.logoutUrl("/logout")
				.clearAuthentication(true)
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID", "remember-me", "XSRF-TOKEN")
				.logoutSuccessUrl("/login");;
			
		}
		@Override
		@Bean
		protected UserDetailsService userDetailsService() {
			UserDetails jbonduser =User.builder()
			.username("jbond")
			.password(passwordEncoder.encode("password"))
			.roles("STANDARD")
			.build();
			UserDetails huser =User.builder()
					.username("hello")
					.password(passwordEncoder.encode("password"))
					.roles("ADMIN")
					.build();
			UserDetails nuser =User.builder()
					.username("newuser")
					.password(passwordEncoder.encode("password"))
					.roles("STANDARD")
					.build();
			return new InMemoryUserDetailsManager(jbonduser,huser,nuser);
				
				
			}
				}
			
		

