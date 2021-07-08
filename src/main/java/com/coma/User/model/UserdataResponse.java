package com.coma.User.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserdataResponse 
{
    private long id;
    private String firstName;
    private String lastName;
    private LocalDateTime lastLogin;
    private LocalDate dob;
    private String email;
    private boolean enabled;
    
    
    public UserdataResponse(long id, String firstName, String lastName, LocalDateTime lastLogin, String email,
    boolean enabled) {
this.id = id;
this.firstName = firstName;
this.lastName = lastName;
this.lastLogin = lastLogin;
this.email = email;
this.enabled = enabled;
}



    public UserdataResponse()
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
