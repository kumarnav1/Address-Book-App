package com.bridgelabz.addressbookapp.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address_book")
@Data
public class AddressBookData {


    @Column(name = "personId")
    private int personId;
    @Column(name = "name")
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;
    private String city;
    private String state;
    private int zip;
    private String password;
    @Id
    public String username;


    public String getUserName() {
        return username;
    }


    public String getUserPassword() {
        return password;
    }

}