package com.course.springbootstarter.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@EnableWebSecurity
public class SpringSecurityConfiguration {
	

	@Autowired
	MyUserDetailsService userDetailsService;
	
	@Autowired
	CustAuthenticationProvider authenticationProvider;
	
	@Autowired
	CustomHeaderAuthFilter customAuthFilter;

	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers(HttpMethod.GET,"/topics*").hasAnyRole("USER","ADMIN")
		.antMatchers(HttpMethod.POST,"/topics*").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT,"/topics*").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE,"/topics*").hasRole("ADMIN")
		.antMatchers(HttpMethod.GET,"/hellos*").hasRole("ADMIN")
		.and()
		.formLogin().and().httpBasic()
		.and()
        .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		
        return http.build();
		
	}
	
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService);
		
		auth.authenticationProvider(authenticationProvider);
		auth.inMemoryAuthentication()
		.withUser("student").password("Student@1997").authorities("ROLE_USER")
		.and()
		.withUser("faculty").password("Faculty@1997").authorities("ROLE_ADMIN").and()
		.passwordEncoder(NoOpPasswordEncoder.getInstance());
		
	}
		
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		
		return NoOpPasswordEncoder.getInstance();
	}
}
