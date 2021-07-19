package com.coma.User.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.coma.Entity.AppUser_Role;
import com.coma.Repository.UserRoleRepo;

public class UserRoleService_Impl implements UserRoleService {

	@Autowired
	UserRoleRepo repo;

	@Override
	public List<AppUser_Role> getAllRole() {
		try {
			List<AppUser_Role> allRoles = repo.findAll();
			return allRoles;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public int createRole(AppUser_Role role) {
		try {
			
			AppUser_Role save = repo.save(role);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int deleteRole(int roleId) {
		try {
			repo.deleteById(roleId);
			return 1;
		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public AppUser_Role getRole(int id) {
	try{
		return repo.findById(id).get();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return null;
	}
		
	}

}
