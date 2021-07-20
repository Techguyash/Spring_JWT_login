package com.coma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtException;

import com.coma.Auth.Model.AuthRequest;
import com.coma.Auth.Model.RegistrationRequest;
import com.coma.Auth.Service.RegistrationService;
import com.coma.security.util.JwtUtil;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController
{
    
    @Autowired
    private RegistrationService registrationService;
    
    
    @Autowired
    private JwtUtil jwt;

    @Autowired
    private AuthenticationManager authManager;

    /*
     * This End point is used to login
     * will return a JWT token for authorization
     * will take @Param of type AuthRequest 
     * */
    @PostMapping("/authenticate")
    public String authenticate(@RequestBody AuthRequest authReq) throws Exception
    {
	try
	{
	    authManager
		    .authenticate(new UsernamePasswordAuthenticationToken(authReq.getEmail(), authReq.getPassword()));

	} 
    catch (JwtException e)
	{
	    throw new Exception(e.getMessage());
	 
	}
	return jwt.generateToken(authReq.getEmail());

    }
    /*
     * this end point is used to register the user data into the system
     * will generate a random Id
     * and sends a confirmation email to enabke the account
     * @Param of type RegistratonReq in the requestBody
     * */
    
    @PostMapping("/register")
    public String register(@RequestBody RegistrationRequest request)
    {
        return registrationService.register(request);
    }
    
    
    /*
     * This is used to confirm the token and enable the user account
     * @Param String of random key generated from "/register" end point
     * this can be used by the Email service
     * */
    @GetMapping("/confirm")
    public String confirm(@RequestParam("token") String token)
    {
        return registrationService.confirmToken(token);
     
    }
  


    
}
