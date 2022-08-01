package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressBookRepository extends JpaRepository<AddressBookData, Integer> {
}
