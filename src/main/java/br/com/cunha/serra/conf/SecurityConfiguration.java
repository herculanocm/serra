package br.com.cunha.serra.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	 

	@Autowired
	private UserDetailsService users;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/login").permitAll()
				// .antMatchers("/produtos/form").hasRole("ADMIN")
				.antMatchers("/produtos/form").permitAll()
				.antMatchers(HttpMethod.POST, "/produtos").hasRole("ADMIN")
				// .antMatchers(HttpMethod.POST,"/produtos").permitAll()
		        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);//We don't need session.
		    

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("SecurityConfiguration - configure - AuthenticationManagerBuilder");
		auth.userDetailsService(users).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**").antMatchers(HttpMethod.OPTIONS, "/**");
	}

	

}
