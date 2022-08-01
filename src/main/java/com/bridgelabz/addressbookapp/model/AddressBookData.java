package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "address_book")
@Data
public class AddressBookData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public AddressBookData() {
    }

    public AddressBookData(AddressBookDTO addressBookDTO) {
        this.updateAddressBookData(addressBookDTO);
    }

    public void updateAddressBookData(AddressBookDTO addressBookDTO) {
        this.setFirstName(addressBookDTO.firstName);
        this.setLastName(addressBookDTO.lastName);
        this.setPhoneNumber(addressBookDTO.phoneNumber);
        this.setEmail(addressBookDTO.email);
        this.setAddress(addressBookDTO.address);
        this.setCity(addressBookDTO.city);
        this.setState(addressBookDTO.state);
        this.setZip(addressBookDTO.zip);
    }
}