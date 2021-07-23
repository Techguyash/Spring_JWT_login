package com.coma.controller;


import com.coma.Auth.Model.RegistrationRequest;
import com.coma.User.model.UserdataResponse;
import com.coma.User.service.UserService_Impl;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/")
public class AdminController 
{
    @Autowired
    UserService_Impl userService;
    
    /*
     * End point for user's CRUD operation
     * these URI can be accessed with ADMIN role only
     * *
     */
    
    
        @GetMapping("{email}")
        public ResponseEntity<UserdataResponse> getUserData(@PathVariable String email)
        {
            UserdataResponse fetchedUserDetails=null;
            try
            {
             fetchedUserDetails = userService.getUserDetails(email); 
            return new ResponseEntity<UserdataResponse>(fetchedUserDetails, HttpStatus.OK);
            }
            catch (Exception e)
            {
		
        	//return new ResponseEntity<UserdataResponse>(HttpStatus.BAD_REQUEST);
        	 return new ResponseEntity<UserdataResponse>(fetchedUserDetails, HttpStatus.BAD_REQUEST);
	    }
        }
        
        @GetMapping()
        public ArrayList<UserdataResponse> getAllUser()
        {
            ArrayList<UserdataResponse> allUser=null;
            try
            {
        	 allUser = userService.getAllUser();
        	if(allUser==null || allUser.isEmpty())
        	{
        	    throw new Exception("No user found");
        	}
        	
            }
            catch (Exception e)
            {
        	e.printStackTrace();
            }
            return allUser;
        }
        
        @DeleteMapping("{email}")
        public String removeUser(@PathVariable String email)
        {
            
           String result = userService.removeUser(email);
           if(result.equalsIgnoreCase("OK"))
           {
               return "OK";
           }
           
           return "failed";
           
        }
        
        @PutMapping
        String updateUserdata(@RequestBody RegistrationRequest request)
        {
            String saveUser = userService.saveUser(request);
            if(saveUser.equalsIgnoreCase("saved"))
            {
                return "success";
            }
            return "failed";
        }
        
}
