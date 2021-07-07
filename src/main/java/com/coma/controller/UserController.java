package com.coma.controller;


import com.coma.User.model.UserdataResponse;
import com.coma.User.service.BillerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController 
{

    @Autowired
    BillerService userService;

        @GetMapping("/{email}")
        public ResponseEntity<UserdataResponse> getUserData(@PathVariable String email)
        {
            UserdataResponse fetchedUserDetails=null;
            try
            {
            
             fetchedUserDetails = userService.fetchUserDetails(email); 
            return new ResponseEntity<UserdataResponse>(fetchedUserDetails, HttpStatus.OK);
            }
            catch (Exception e)
            {
		// TODO: handle exception
        	//return new ResponseEntity<UserdataResponse>(HttpStatus.BAD_REQUEST);
        	 return new ResponseEntity<UserdataResponse>(fetchedUserDetails, HttpStatus.BAD_REQUEST);
	    }
        }
}
