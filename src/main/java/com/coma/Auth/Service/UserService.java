package com.coma.Auth.Service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.coma.Auth.Model.ConfirmationToken;
import com.coma.Entity.AppUser;
import com.coma.Repo.UserRepo;




@Service
public class UserService implements UserDetailsService
{
    private final static String USER_NOT_FOUND_MSG="User with email : %s not found";
    
    @Autowired
    UserRepo repo;
    
    @Autowired
    BCryptPasswordEncoder passswordEncoder;
    
    @Autowired
    ConfirmationTokenService tokenService;
    

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {
	
	return repo.findByEmail(email)
		 .orElseThrow(()-> new UsernameNotFoundException(USER_NOT_FOUND_MSG));
    }
    
    public String signUp(AppUser req)
    {
	boolean userExits=repo.findByEmail(req.getEmail()).isPresent();
	if(userExits)
	{
	    throw new IllegalStateException("User already exist");
	}
	
	
	req.setPassword(passswordEncoder.encode(req.getPassword()));
	repo.save(req);
	
	//TODO: generate the verification token
	String token = UUID.randomUUID().toString();
	ConfirmationToken ConfirmationToken= new ConfirmationToken(token, LocalDateTime.now(), LocalDateTime.now().plusMinutes(15),req);
	tokenService.saveConfirmationToken(ConfirmationToken);
	return token;
	
    }
    
    public int enableAppUser(String email) {
        return repo.enableAppUser(email);
    }

}
