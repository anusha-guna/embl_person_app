package embl.Person;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
@Configuration
public class APIAuthenticationUtil extends WebSecurityConfigurerAdapter {
	
	
	//Used to implement the basic authentication using username and password.
	 @Override
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.inMemoryAuthentication()
		 .withUser("embluser").password("{noop}password").roles("USER")
		 .and()
		 .withUser("embladmin").password("{noop}password").roles("USER", "ADMIN");

}//APIs security definitions are given here. 
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {

	        http
	                //HTTP Basic authentication
	                .httpBasic()
	                .and()
	                .authorizeRequests()
	                .antMatchers(HttpMethod.GET, "/persons/**").hasRole("USER")
	                .antMatchers(HttpMethod.POST, "/persons").hasRole("ADMIN")
	                .antMatchers(HttpMethod.PUT, "/persons/**").hasRole("ADMIN")
	                .antMatchers(HttpMethod.PATCH, "/persons/**").hasRole("ADMIN")
	                .antMatchers(HttpMethod.DELETE, "/persons/**").hasRole("ADMIN")
	                .and()
	                .csrf().disable()
	                .formLogin().disable();
	                 http.headers().frameOptions().disable();//H2 database UI mode requires to disable frameoptions.
	    }

}

