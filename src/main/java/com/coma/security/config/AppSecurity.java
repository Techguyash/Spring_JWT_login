package com.coma.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.coma.Auth.Service.UserService_Registration;
import com.coma.security.Filter.JwtFilter;

@Configuration
@EnableWebSecurity
public class AppSecurity extends WebSecurityConfigurerAdapter
{
    @Autowired
    UserService_Registration userService;
    
    @Autowired
    private JwtFilter jwtFilter;
    
    @Autowired
    private  BCryptPasswordEncoder bCryptPasswordEncoder;
    
   

    @Override
    protected void configure(HttpSecurity http) throws Exception 
    {
	
	
	 http.csrf().disable()
	        .authorizeRequests()
	       .antMatchers("/api/v*/auth/**").permitAll()
	       .antMatchers("/api/v*/admin/**").hasRole("ADMIN")
	       .antMatchers("/hello").permitAll()
	        .anyRequest().authenticated()
                .and().exceptionHandling().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
      http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
	 auth.authenticationProvider(daoauthenticationProvider());
	//auth.userDetailsService(userService);
    }
    
    @Bean
    protected DaoAuthenticationProvider daoauthenticationProvider()
    {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(userService);
        return provider;

    }
    
    
    @Bean(name=BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception
    {
	return super.authenticationManagerBean();
    }

}
