package com.coma.Auth.Model;



public class RegistrationRequest
{
 
    private  String firstName;
    private  String lastName;
    private  String email;
    private  String password;
    private String userRole;
    
   
    public String getFirstName()
    {
        return firstName;
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
