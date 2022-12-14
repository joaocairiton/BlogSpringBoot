package com.spring.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Controller;


@Controller
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private static final String[] AUTH_LIST = {
	        "/",
	        "/posts",
	        "/posts/{id}"
	    };

	    @Override
	    protected void configure(HttpSecurity http) throws Exception{
	        http.csrf().disable().authorizeRequests()
	                .antMatchers(AUTH_LIST).permitAll()
	                .anyRequest().authenticated()
	                .and().formLogin().permitAll()
	                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	    }

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
	        auth.inMemoryAuthentication()
	                .withUser("fidido").password("{noop}153").roles("ADMIN");
	    }

	    @Override
	    public void configure(WebSecurity web) throws Exception{
	        web.ignoring().antMatchers("/bootstrap/**");
	        web.ignoring().antMatchers("/bootstrap/**", "/style/**");
	    }
	}