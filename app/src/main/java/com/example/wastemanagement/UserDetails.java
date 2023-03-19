package com.example.wastemanagement;

public class UserDetails {
    public String username,email,password,mobileno;

    public UserDetails() {}

    public UserDetails(String username, String email, String password,String mobileno) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.mobileno = mobileno;

    }
}
