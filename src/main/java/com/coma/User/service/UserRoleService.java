package com.coma.User.service;

import java.util.List;

import com.coma.Entity.AppUser_Role;

public interface UserRoleService
{
    
    List<AppUser_Role> getAllRole();
    int createRole(AppUser_Role role);
    int deleteRole(int roleId);
    

}
