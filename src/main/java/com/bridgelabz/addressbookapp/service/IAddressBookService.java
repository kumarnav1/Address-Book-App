package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;

import java.util.List;

public interface IAddressBookService {

    List<AddressBookData> getAddressBookData();

    List<AddressBookData> sortAddressBookDataByComparator();

    List<AddressBookData> sortContactsByCityOrderBy();

    List<AddressBookData> sortContactsByCity(String city);

    AddressBookData getAddressBookDataById(int personId);

    AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);

    AddressBookData updateAddressBookData(int personId, AddressBookDTO addressBookDTO);

    void deleteAddressBookData(int personId);
}