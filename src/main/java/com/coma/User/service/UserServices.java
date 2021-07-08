package com.coma.User.service;


import java.util.ArrayList;

import com.coma.Auth.Model.RegistrationRequest;
import com.coma.User.model.UserdataResponse;

public interface UserServices
{
     UserdataResponse getUserDetails(String email);
     ArrayList<UserdataResponse> getAllUser(); 
     String removeUser(String email);
     String saveUser(RegistrationRequest req);
     

}
