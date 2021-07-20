package com.coma.User.service;

import com.coma.Entity.AppUser_Role;
import com.coma.Repository.UserRoleRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

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
      return null;
    }
  }

  @Override
  public AppUser_Role createRole(AppUser_Role role) {
    try {
      List<AppUser_Role> allRole = getAllRole();
      for (AppUser_Role roles : allRole) 
	  {
        if (roles.getRole().equals(role.getRole())) {
          throw new Exception("Role already present");
        }
      }
       return repo.save(role);
      
    } 
	catch (Exception e) {
      e.printStackTrace();
      return null;
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
    try {
      return repo.findById(id).get();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
