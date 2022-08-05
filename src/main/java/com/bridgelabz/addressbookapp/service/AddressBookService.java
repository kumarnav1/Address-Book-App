package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.exception.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.repository.IAddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Slf4j
@Service
public class AddressBookService implements IAddressBookService {

    @Autowired
    IAddressBookRepository service;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<AddressBookData> getAddressBookData() {
        return service.findAll();
    }

    @Override
    public List<AddressBookData> sortAddressBookDataByComparator() {
        List<AddressBookData> listOfData = service.findAll();
        listOfData.sort(Comparator.comparing(AddressBookData::getCity));
        return listOfData;
    }

    @Override
    public List<AddressBookData> sortContactsByCityOrderBy() {
        return service.findContactsByCityOrderBy();
    }

    @Override
    public List<AddressBookData> sortContactsByCity(String city) {
        return service.sortContactByCity(city);
    }

    @Override
    public List<AddressBookData> sortAddressBookDataStateByComparator() {
        List<AddressBookData> listOfData = service.findAll();
        listOfData.sort(Comparator.comparing(AddressBookData::getState));
        return listOfData;
    }

    @Override
    public List<AddressBookData> sortContactsByStateOrderBy() {
        return service.findContactsByStateOrderBy();
    }

    @Override
    public List<AddressBookData> sortContactsByState(String state) {
        return service.sortContactByState(state);
    }

    @Override
    public AddressBookData getAddressBookDataById(String personId) {
        return service.findById(personId).orElseThrow(() -> new AddressBookException("Person not found In the List"));
    }

    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = modelMapper.map(addressBookDTO, AddressBookData.class);
        service.save(addressBookData);
        return addressBookData;
    }

    @Override
    public AddressBookData updateAddressBookData(String personId, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = this.getAddressBookDataById(personId);
        modelMapper.map(addressBookDTO, addressBookData);
        service.save(addressBookData);
        return addressBookData;
    }

    @Override
    public void deleteAddressBookData(String personId) {
        AddressBookData addressBookData = this.getAddressBookDataById(personId);
        service.delete(addressBookData);
    }


}