package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface IAddressBookRepository extends JpaRepository<AddressBookData, String> {

    @Query(value = "select * from address_book order by city", nativeQuery = true)
    List<AddressBookData> findContactsByCityOrderBy();

    @Query(value = "select * from address_book where city=:city", nativeQuery = true)
    List<AddressBookData> sortContactByCity(String city);

    @Query(value = "select * from address_book order by state", nativeQuery = true)
    List<AddressBookData> findContactsByStateOrderBy();

    @Query(value = "select * from address_book where state=:state", nativeQuery = true)
    List<AddressBookData> sortContactByState(String state);

    public User findByUsername(String username);
}