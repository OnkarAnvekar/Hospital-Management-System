package com.hms.spring_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.hms.jwt.JwtFilter;

@SuppressWarnings("deprecation")
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtFilter jwtFilter;
	@Autowired
	UserDetailsService userServiceDetaisl;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userServiceDetaisl).passwordEncoder(passwordEncoder());
		super.configure(auth);
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * http.authorizeRequests().antMatchers(HttpMethod.POST).hasAnyRole("ADMIN",
		 * "MANAGER") .antMatchers(HttpMethod.PUT).hasAnyRole("ADMIN","MANAGER")
		 * .antMatchers(HttpMethod.DELETE).hasAnyRole("MANAGER")
		 * .antMatchers(HttpMethod.GET,"/v1/cars").hasAnyRole("ADMIN","MANAGER","USER")
		 * 
		 * .antMatchers(HttpMethod.GET,"/v1/users").hasAnyRole("ADMIN","MANAGER")
		 * .antMatchers(HttpMethod.GET,"/v1/users/{userId}").access(
		 * "@userSecurity.hasUserId(authentication,#userId)") ;
		 * 
		 * 
		 *  sss
		 * 
		 * 
		 * http.cors().disable(); http.csrf().disable();
		 * http.headers().frameOptions().disable();
		 * 
		 * super.configure(http);
		 * 
		 */
//     http.authorizeRequests().antMatchers("/api/authenticate").hasAnyRole("PATIENT","ADMIN","PATIENT","reception".toUpperCase());
     
     
     
     
//     		http.csrf().disable().authorizeRequests().antMatchers("/api/authenticate").permitAll().anyRequest().authenticated()
//			.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
     		http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

//		super.configure(http);
	}

	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

}
