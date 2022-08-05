package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;

import java.util.List;

public interface IAddressBookService {

    List<AddressBookData> getAddressBookData();

    List<AddressBookData> sortAddressBookDataByComparator();

    List<AddressBookData> sortContactsByCityOrderBy();

    List<AddressBookData> sortContactsByCity(String city);

    List<AddressBookData> sortAddressBookDataStateByComparator();

    List<AddressBookData> sortContactsByStateOrderBy();

    List<AddressBookData> sortContactsByState(String state);

    AddressBookData getAddressBookDataById(String personId);

    AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);

    AddressBookData updateAddressBookData(String personId, AddressBookDTO addressBookDTO);

    void deleteAddressBookData(String personId);


}