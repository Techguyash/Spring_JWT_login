package com.coma.Auth.Model;

import java.time.LocalDate;

public class RegistrationRequest
{
 
    private  String firstName;
    private  String lastName;
    private  String email;
    private  String password;
    private String userRole;
    private LocalDate dob;
    
   
    public String getFirstName()
    {
        return firstName;
    }
    public LocalDate getDob() {
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    public String getLastName()
    {
        return lastName;
    }
    public String getEmail()
    {
        return email;
    }
    public String getPassword()
    {
        return password;
    }
    
    public String getUserRole()
    {
        return userRole;
    }
    
    @Override
    public String toString()
    {
	return "RegistrationRequest [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
		+ ", password=" + password + ", userRole=" + userRole + "]";
    }
}
