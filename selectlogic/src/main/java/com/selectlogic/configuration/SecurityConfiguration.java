package com.selectlogic.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration

public class SecurityConfiguration extends WebSecurityConfigurerAdapter	 {
	

	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.authorizeRequests().antMatchers("/").permitAll();
		http.csrf().disable();
        http.headers().frameOptions().disable();
        
	}*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/css/**").permitAll()
				.anyRequest().fullyAuthenticated()
				.and()
			.formLogin();
	}

	@Configuration
	protected static class AuthenticationConfiguration extends
			GlobalAuthenticationConfigurerAdapter {

		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception {
			auth.ldapAuthentication().userDnPatterns("uid={0},ou=people").groupSearchBase("ou=groups")
			.contextSource().ldif("classpath:test-server.ldif");
			
			
					
					
		}
	}
	
	 

}
