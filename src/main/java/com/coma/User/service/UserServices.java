package com.coma.User.service;


import java.util.ArrayList;


import com.coma.User.model.UserdataResponse;

public interface UserServices
{
     UserdataResponse getUserDetails(String email);
     ArrayList<UserdataResponse> getAllUser(); 

}
