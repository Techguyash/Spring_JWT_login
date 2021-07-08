package com.coma.User.service;

import com.coma.Entity.AppUser;
import com.coma.Repo.UserRepo;
import com.coma.User.model.UserdataResponse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService_Impl implements UserServices
{

    @Autowired
    UserRepo userRepo;

    private AppUser appUser = null;

    public UserdataResponse getUserDetails(String email)
    {

	appUser = userRepo.findByEmail(email).get();

	if (appUser == null)
	{
	    throw new UsernameNotFoundException("Invalid user please register to continue");
	}
	UserdataResponse responseData = new UserdataResponse(appUser.getId(), appUser.getFirstName(),
		appUser.getLastName(), appUser.getLastLogin(), appUser.getEmail(), appUser.isEnabled());

	return responseData;

    }

    @Override
    public ArrayList<UserdataResponse> getAllUser()
    {
	List<AppUser> allUser = null;
	ArrayList<UserdataResponse> responseList = new ArrayList<>();
	try
	{
	    allUser = userRepo.findAll();
	    if (allUser.isEmpty() || allUser == null)
	    {
		throw new IllegalStateException("No user is present in the system");
	    }

	    for (AppUser user : allUser)
	    {
		UserdataResponse userdata = new UserdataResponse();
		userdata.setEmail(user.getEmail());
		userdata.setDob(user.getDob());
		userdata.setFirstName(user.getFirstName());
		userdata.setLastName(user.getLastName());
		userdata.setEnabled(user.isEnabled());
		userdata.setId(user.getId());
		userdata.setLastLogin(user.getLastLogin());
		responseList.add(userdata);
	    }

	} catch (Exception e)
	{
	    e.printStackTrace();
	}
	return responseList;
    }

}
