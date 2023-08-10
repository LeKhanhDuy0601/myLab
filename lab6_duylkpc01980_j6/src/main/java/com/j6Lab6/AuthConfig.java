package com.j6Lab6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	BCryptPasswordEncoder pe;

	// Mã hoá mật khẩu
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// quản lý người dùng
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.withUser("user1").password(pe.encode("123")).roles("GUEST").and()
				.withUser("user2").password(pe.encode("123")).roles("USER", "GUEST").and()
				.withUser("user3").password(pe.encode("123")).roles("ADMIN", "USER", "GUEST");
	}

	// phân quyền
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().cors().disable();

		http.authorizeRequests()
		
//				.antMatchers("/home/admins").hasRole("ADMIN")
//				.antMatchers("/home/users").hasAnyRole("ADMIN","USER")
//				.antMatchers("/home/authenticated").authenticated()
				.anyRequest().permitAll();

		http.exceptionHandling().accessDeniedPage("/auth/access/denied");
		
		http.formLogin()
		.loginPage("/auth/login/form")
		.loginProcessingUrl("/auth/login")
		.defaultSuccessUrl("/auth/login/success",false)
		.failureUrl("/auth/login/error")
		.usernameParameter("username")
		.passwordParameter("password");
		http.rememberMe()
		.rememberMeParameter("remember");
		
		http.logout()
		.logoutUrl("/auth/logoff")
		.logoutSuccessUrl("/auth/logoff/success");
		
	}
}
