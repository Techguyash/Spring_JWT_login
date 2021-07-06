package com.coma.security.Filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.coma.Auth.Service.UserService;
import com.coma.security.util.JwtUtil;



@Component
public class JwtFilter extends OncePerRequestFilter
{

    @Autowired
    JwtUtil jwtUtil;
    
    @Autowired
    UserService service;

    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	    throws ServletException, IOException
    {
	
	
	 String header = request.getHeader("Authorization");

	        String token = null;
	        String email = null;

	        if (header != null && header.startsWith("Bearer ")) {
	           
	            token = header.substring(7);
	            email = jwtUtil.extractUsername(token);
	        }

	        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {

	            UserDetails userDetails = service.loadUserByUsername(email);

	            if (jwtUtil.validateToken(token, userDetails)) {

	                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
	                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	                usernamePasswordAuthenticationToken
	                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
	            }
	        }
	        filterChain.doFilter(request, response);
	
    }

}
