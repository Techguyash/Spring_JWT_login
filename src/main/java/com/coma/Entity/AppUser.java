package com.coma.Entity;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
public class AppUser implements UserDetails
{

    @SequenceGenerator(
	        name = "Seq_userId",
	        allocationSize = 1,
	        sequenceName = "Seq_userId"
	    )

	    @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Seq_userId")
	    private Long id;
	    private String firstName;
	    private String lastName;
	    private String email;
	    private String password;
	    private boolean enabled=false;
	    private String appUserRole;
	    private boolean locked=false;
	    
	    

	    public AppUser()
	    {
		super();
	    }
	    
	  

	    public AppUser(String firstName, String lastName, String email, String password, String appUserRole)
	    {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.appUserRole = appUserRole;
	    }

	    	
	    @Override
	    public String toString()
	    {
		return "AppUser [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
			+ ", password=" + password + ", enabled=" + enabled + ", appUserRole=" + appUserRole
			+ ", locked=" + locked + "]";
	    }

	    public Long getId()
	    {
	        return id;
	    }
	    public void setId(Long id)
	    {
	        this.id = id;
	    }
	    public String getFirstName()
	    {
	        return firstName;
	    }
	    public void setFirstName(String firstName)
	    {
	        this.firstName = firstName;
	    }
	    public String getLastName()
	    {
	        return lastName;
	    }
	    public void setLastName(String lastName)
	    {
	        this.lastName = lastName;
	    }
	    public String getEmail()
	    {
	        return email;
	    }
	    public void setEmail(String email)
	    {
	        this.email = email;
	    }
	  
	    public void setPassword(String password)
	    {
	        this.password = password;
	    }
	  
	    public void setEnabled(boolean enabled)
	    {
	        this.enabled = enabled;
	    }
	    public String getAppUserRole()
	    {
	        return appUserRole;
	    }
	    public void setAppUserRole(String appUserRole)
	    {
	        this.appUserRole = appUserRole;
	    }
	    public boolean isLocked()
	    {
	        return locked;
	    }
	    public void setLocked(boolean locked)
	    {
	        this.locked = locked;
	    }

	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities()
	    {
		 SimpleGrantedAuthority authorities=new SimpleGrantedAuthority(getAppUserRole());

		        return Collections.singletonList(authorities);
	    }

	    @Override
	    public String getUsername()
	    {
		return email;
	    }

	    @Override
	    public boolean isAccountNonExpired()
	    {
		return true;
	    }

	    @Override
	    public boolean isAccountNonLocked()
	    {
		return !isLocked();
	    }

	    @Override
	    public boolean isCredentialsNonExpired()
	    {
		return true;
	    }

	    @Override
	    public String getPassword()
	    {
		return password;
	    }

	    @Override
	    public boolean isEnabled()
	    {
		return enabled;
	    }

    
}
