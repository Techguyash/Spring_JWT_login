package com.coma.User.service;



import java.util.Optional;

import com.coma.Entity.AppUser;
import com.coma.Repo.UserRepo;
import com.coma.User.model.UserdataResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BillerService {

    @Autowired
    UserRepo userRepo;
    
    private AppUser appUser=null;
 

    public UserdataResponse fetchUserDetails(String email)
    {

        appUser = userRepo.findByEmail(email).get();

         if(appUser==null)
        {
            throw new UsernameNotFoundException("Invalid user please register to continue");
        }
        UserdataResponse responseData= new UserdataResponse(appUser.getId(), appUser.getFirstName(), appUser.getLastName(), appUser.getLastLogin(), appUser.getEmail(), appUser.isEnabled());
        
        return responseData;
        
    }

    
}
