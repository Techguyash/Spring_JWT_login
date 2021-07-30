package com.coma.User.service;

import com.coma.Auth.Model.RegistrationDTOReq;
import com.coma.Entity.AppUser;
import com.coma.Repository.TokenRepo;
import com.coma.Repository.UserRepo;
import com.coma.User.model.UserdataDTORes;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService_Impl implements UserServices {

	@Autowired
	UserRepo userRepo;

	@Autowired
	TokenRepo tokenRepo;

	private AppUser appUser = null;

	public UserdataDTORes getUserDetails(String email) {

		appUser = userRepo.findByEmail(email).get();

		if (appUser == null) {
			throw new UsernameNotFoundException("No User found");
		}
		UserdataDTORes responseData = new UserdataDTORes(appUser.getId(), appUser.getName(),
				 appUser.getLastLogin(), appUser.getEmail(), appUser.isEnabled());

		return responseData;

	}

	@Override
	public ArrayList<UserdataDTORes> getAllUserDetails() {
		List<AppUser> allUser = null;
		ArrayList<UserdataDTORes> responseList = new ArrayList<>();
		try {
			allUser = userRepo.findAll();
			if (allUser.isEmpty() || allUser == null) {
				throw new IllegalStateException("No User found");
			}

			for (AppUser user : allUser) {
				UserdataDTORes userdata = new UserdataDTORes();
				userdata.setEmail(user.getEmail());
				userdata.setDob(user.getDob());
				userdata.setName(user.getName());
				userdata.setEnabled(user.isEnabled());
				userdata.setId(user.getId());
				userdata.setLastLogin(user.getLastLogin());
				responseList.add(userdata);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseList;
	}

	@Override
	public String removeUser(String email) {
		try {
			long id = getUserDetails(email).getId();
			if (id >= 0) {
				tokenRepo.deleteById(id);
				userRepo.deleteByEmail(email);
			}
			return "OK";

		} catch (Exception e) {
			e.printStackTrace();
			return "NOT OK";
		}

	}

	public String saveUser(RegistrationDTOReq req)
	{
		try{
		long id=userRepo.findByEmail(req.getEmail()).get().getId();
		if(id>=0)
		{
		AppUser user=new AppUser();
		user.setId(id);
		user.setDob(req.getDob());
		user.setEmail(req.getEmail());
		user.setName(req.getName());
		userRepo.save(user);
		}
			return "saved";
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return "failed";
	}
	}

}
