package com.coma.User.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserdataDTORes 
{
    private long id;
    private String Name;
    private LocalDateTime lastLogin;
    private LocalDate dob;
    private String email;
    private boolean enabled;
    
    
    public UserdataDTORes(long id, String Name, LocalDateTime lastLogin, String email,
    boolean enabled) {
this.id = id;
this.Name = Name;
this.lastLogin = lastLogin;
this.email = email;
this.enabled = enabled;
}



    public UserdataDTORes()
    {
	
    }



    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public boolean getEnabled() {
        return this.enabled;
    }


  

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
}
