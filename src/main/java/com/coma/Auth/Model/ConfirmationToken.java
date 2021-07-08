package com.coma.Auth.Model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.coma.Entity.AppUser;


@Entity
public class ConfirmationToken
{
    @SequenceGenerator(name = "Seq_email_token_id", allocationSize = 1, sequenceName = "Seq_email_token_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Seq_email_token_id")
    private Long id;
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime expiresAt;
    private LocalDateTime confirmedAt;
    @ManyToOne
    @JoinColumn(nullable = false, name = "app_user_id")
    @Cascade(CascadeType.ALL)
    private AppUser appUser;

    public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiresAt,
	    AppUser appUser)
    {
	super();
	this.token = token;
	this.createdAt = createdAt;
	this.expiresAt = expiresAt;
	this.appUser = appUser;
    }

    public ConfirmationToken()
    {
	super();
    }

    public Long getId()
    {
	return id;
    }

    public void setId(Long id)
    {
	this.id = id;
    }

    public String getToken()
    {
	return token;
    }

    public void setToken(String token)
    {
	this.token = token;
    }

    public LocalDateTime getCreatedAt()
    {
	return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt)
    {
	this.createdAt = createdAt;
    }

    public LocalDateTime getExpiresAt()
    {
	return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt)
    {
	this.expiresAt = expiresAt;
    }

    public LocalDateTime getConfirmedAt()
    {
	return confirmedAt;
    }

    public void setConfirmedAt(LocalDateTime confirmedAt)
    {
	this.confirmedAt = confirmedAt;
    }

    public AppUser getAppUser()
    {
        return appUser;
    }

    public void setAppUser(AppUser appUser)
    {
        this.appUser = appUser;
    }
}