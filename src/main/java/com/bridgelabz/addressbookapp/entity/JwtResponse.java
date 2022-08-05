package com.bridgelabz.addressbookapp.entity;

import com.bridgelabz.addressbookapp.model.AddressBookData;

public class JwtResponse {

    private AddressBookData user;
    private String jwtToken;

    public JwtResponse(AddressBookData user, String jwtToken) {
        this.user = user;
        this.jwtToken = jwtToken;
    }

    public AddressBookData getUser() {
        return user;
    }

    public void setUser(AddressBookData user) {
        this.user = user;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
