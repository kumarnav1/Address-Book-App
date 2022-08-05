package com.bridgelabz.addressbookapp.entity;

import lombok.Data;

@Data
public class LoginUser {

    public String username;
    public String password;
    public String role;
    public String email;
    public boolean enabled;
}