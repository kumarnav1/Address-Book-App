package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.entity.CustomUserDetails;
import com.bridgelabz.addressbookapp.repository.IAddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IAddressBookRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("User not Found!!");
        }
        else{
            return new CustomUserDetails(user);
        }


//       if(username.equals("Nikita")){
//           return new User("Nikita", "Nikita@123", new ArrayList<>());
//       }else {
//           throw new UsernameNotFoundException("User not found!!!");
//       }
    }
}
