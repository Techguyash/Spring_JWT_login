package com.coma.User.model;

import java.time.LocalDate;

public class UserdataDTOReq {
    private String Name;
    private String email;
    private String password;
    private LocalDate dob;



    public UserdataDTOReq() {
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDob() {
        return this.dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

}
