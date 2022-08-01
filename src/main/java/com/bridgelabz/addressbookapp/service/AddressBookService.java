package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.exception.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.repository.IAddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AddressBookService implements IAddressBookService {

    @Autowired
    IAddressBookRepository service;

    @Override
    public List<AddressBookData> getAddressBookData() {
        return service.findAll();
    }

    @Override
    public AddressBookData getAddressBookDataById(int personId) {
        return service.findById(personId)
                .orElseThrow(() -> new AddressBookException("Person not found In the List"));
    }

    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(addressBookDTO);
        service.save(addressBookData);
        return addressBookData;
    }

    @Override
    public AddressBookData updateAddressBookData(int personId, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = this.getAddressBookDataById(personId);
        addressBookData.updateAddressBookData(addressBookDTO);
        service.save(addressBookData);
        return addressBookData;
    }

    @Override
    public void deleteAddressBookData(int personId) {
        AddressBookData addressBookData = this.getAddressBookDataById(personId);
        service.delete(addressBookData);
    }
}