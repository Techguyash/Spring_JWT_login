package com.coma.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coma.Entity.AppUser_Role;

public interface UserRoleRepo extends JpaRepository<AppUser_Role, Integer>
{

}
