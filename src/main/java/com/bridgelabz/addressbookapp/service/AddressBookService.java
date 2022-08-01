package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    @Override
    public List<AddressBookData> getAddressBookData() {
        List<AddressBookData> addressBookDataList = new ArrayList<>();
        AddressBookData addressBookData = new AddressBookData(1, new AddressBookDTO("Navneet",
                "Kumar", "9304093785", "navkr007@gmail.com", "Ginjo thakur gaon",
                "Ranchi", "Jharkhand", 835205));
        addressBookDataList.add(addressBookData);
        return addressBookDataList;
    }

    @Override
    public AddressBookData getAddressBookDataById(int personId) {
        return new AddressBookData(personId, new AddressBookDTO("Navneet",
                "Kumar", "9304093785", "navkr007@gmail.com", "Ginjo thakur gaon",
                "Ranchi", "Jharkhand", 835205));
    }

    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        return new AddressBookData(1, addressBookDTO);
    }

    @Override
    public AddressBookData updateAddressBookData(int personId, AddressBookDTO addressBookDTO) {
        return new AddressBookData(personId, addressBookDTO);
    }

    @Override
    public void deleteAddressBookData(int personId) {

    }
}
