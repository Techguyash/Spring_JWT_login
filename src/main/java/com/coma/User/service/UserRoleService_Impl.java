package com.coma.User.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.coma.Entity.AppUser_Role;
import com.coma.Repo.UserRoleRepo;

public class UserRoleService_Impl implements UserRoleService
{
    
    @Autowired
    UserRoleRepo repo;

    @Override
    public List<AppUser_Role> getAllRole()
    {
	
	List<AppUser_Role> allRoles = repo.findAll();
	return allRoles;
    }

    @Override
    public int createRole(AppUser_Role role)
    {
	try
	{
	AppUser_Role save = repo.save(role);
	return 1;
	}
	catch (Exception e) {
	    return 0;
	}
    }

    @Override
    public int deleteRole(int roleId)
    {
	try
	{
	    repo.deleteById(roleId);
	    return 1;
	}
	catch (Exception e) {
	    return 0;
	}
    }

  

}
