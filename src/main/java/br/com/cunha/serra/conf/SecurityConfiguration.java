package br.com.cunha.serra.conf;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/login").permitAll()
		.antMatchers("/produtos/form").hasRole("ADMIN")
		.antMatchers("/shopping/**").permitAll()
		.antMatchers(HttpMethod.POST,"/produtos").hasRole("ADMIN")
		.antMatchers("/produtos/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		;
	}

}
