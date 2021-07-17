package com.coma.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vendor
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long vendorId;
    private String name;
    private String address;
    private String email;
    private LocalDate dob;
    private String gstNo;
    private String mobile;




    public Vendor() {
    }



    public Vendor(long vendorId, String name, String address, String email, LocalDate dob, String gstNo, String mobile) {
        this.vendorId = vendorId;
        this.name = name;
        this.address = address;
        this.email = email;
        this.dob = dob;
        this.gstNo = gstNo;
        this.mobile = mobile;
    }



    public long getVendorId() {
        return this.vendorId;
    }

    public void setVendorId(long vendorId) {
        this.vendorId = vendorId;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return this.dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGstNo() {
        return this.gstNo;
    }

    public void setGstNo(String gstNo) {
        this.gstNo = gstNo;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    

}
