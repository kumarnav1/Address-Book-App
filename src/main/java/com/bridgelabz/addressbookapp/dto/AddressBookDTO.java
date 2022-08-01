package com.bridgelabz.addressbookapp.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class AddressBookDTO {
    @Pattern(regexp = "^[A-Z]{1}[A-Za-z]{1,}$", message = "Invalid First Name")
    public String firstName;
    @Pattern(regexp = "^[A-Z]{1}[A-Za-z]{1,}$", message = "Invalid Last Name")
    public String lastName;
    public String phoneNumber;
    public String email;
    public String address;
    public String city;
    public String state;
    public int zip;

    public AddressBookDTO(String firstName, String lastName, String phoneNumber, String email,
                          String address, String city, String state, int zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
}