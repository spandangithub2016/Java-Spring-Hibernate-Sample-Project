package com.stpl.trainee.bean;

import org.springframework.stereotype.Component;

@Component
public class StudentBean {
    
   
    private String userName;
    private String fullName;
    private String pasword;
    private String address;
    private String dob;
    private String gender;
    private String email;
    private String contact;
    
    public String getUsername() {
        return userName;
    }
    public void setUsername(String username) {
        this.userName = username;
    }
    public String getFullname() {
        return fullName;
    }
    public void setFullname(String fullname) {
        this.fullName = fullname;
    }
    public String getPasword() {
        return pasword;
    }
    public void setPasword(String pasword) {
        this.pasword = pasword;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    
    
    
}
