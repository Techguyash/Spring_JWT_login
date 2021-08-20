package com.coma.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Customer
{
    @SequenceGenerator(
        name = "Seq_customerId",
        allocationSize = 1,
        sequenceName = "Seq_customerId"
    )
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Seq_customerId")
    private long customerId;
    private String email;
    private String name;
    private String address;
    private String mobile;
    private LocalDate dob;


    public Customer(long customerId, String email, String name, String address, String mobile, LocalDate dob) {
        this.customerId = customerId;
        this.email = email;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
        this.dob = dob;
    }

    public long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public LocalDate getDob() {
        return this.dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Customer() {
    }


}
