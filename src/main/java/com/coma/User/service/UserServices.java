package com.coma.User.service;


import java.util.ArrayList;

import com.coma.Auth.Model.RegistrationDTOReq;
import com.coma.User.model.UserdataDTORes;

public interface UserServices
{
     UserdataDTORes getUserDetails(String email);
     ArrayList<UserdataDTORes> getAllUserDetails(); 
     String removeUser(String email);
     String saveUser(RegistrationDTOReq req);
     

}
