package com.coma.Auth.Model;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;



public class RegistrationDTOReq
{
    @NotNull(message = "Required : Name ")
    private  String Name;
    @NotNull(message = "Required : email ")
    @Email(message = "Not an valid email")
    private  String email;
    @NotNull(message = "Required : password ")
    private  String password;
    @NotNull(message = "Required DOB")
    private LocalDate dob;
    

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
  
 
    public LocalDate getDob() {
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
  
    public String getEmail()
    {
        return email;
    }
    public String getPassword()
    {
        return password;
    }
    
  
    
    @Override
    public String toString()
    {
	return "RegistrationRequest [firstName=" + ", email=" + email
		+ ", password=" + password;
    }
}
