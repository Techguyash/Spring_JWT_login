package com.coma.controller.admin;


import com.coma.Auth.Model.RegistrationDTOReq;
import com.coma.ExceptionHandler.RunTimeException.BusinessApiException;
import com.coma.User.model.UserdataDTORes;
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
@RequestMapping("/api/v1/admin/user/")
public class UserController 
{
    @Autowired
    UserService_Impl userService;
    
    /*
     * End point for user's CRUD operation
     * these URI can be accessed with ADMIN role only
     * *
     */
    
    
        @GetMapping("{email}")
        public ResponseEntity<UserdataDTORes> getUserData(@PathVariable String email)
        {
            UserdataDTORes fetchedUserDetails=null;
             fetchedUserDetails = userService.getUserDetails(email); 
            return new ResponseEntity<UserdataDTORes>(fetchedUserDetails, HttpStatus.OK);

        }
        
        @GetMapping()
        public ResponseEntity<Object> getAllUser() throws BusinessApiException
        {
            ArrayList<UserdataDTORes> allUser=null;
        	 allUser = userService.getAllUserDetails();
        	if(allUser==null || allUser.isEmpty())
        	{
        	    throw new BusinessApiException("No user found");
        	}
          
            return new ResponseEntity<Object>(allUser,HttpStatus.OK);
        }
        
        @DeleteMapping("{email}")
        public ResponseEntity<Object> removeUser(@PathVariable String email)
        {
            
           String result = userService.removeUser(email);
           if(result.equalsIgnoreCase("OK"))
           {
               return new ResponseEntity<>("success",HttpStatus.OK);
           }
           else{
               throw new BusinessApiException("failed to delete");
           }
       
        }
    
        
        
        @PutMapping
        public ResponseEntity<Object> updateUserdata(@RequestBody RegistrationDTOReq request) throws Exception
        {
            String saveUser = userService.saveUser(request);
            if(saveUser.equalsIgnoreCase("saved"))
            {
                return new ResponseEntity<>("success",HttpStatus.OK);
            }
           else{
               throw new Exception("error, check logs");
           }
        }
        
}
