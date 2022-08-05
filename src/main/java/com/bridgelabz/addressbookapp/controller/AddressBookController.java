package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.entity.JwtResponse;
import com.bridgelabz.addressbookapp.entity.LoginUser;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.service.CustomUserDetailsService;
import com.bridgelabz.addressbookapp.service.IAddressBookService;

import com.bridgelabz.addressbookapp.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;


    @PostMapping({"/firstlogin"})
    public ResponseEntity<?>  createJwtToken(@RequestBody LoginUser loginUser) throws Exception {
        System.out.println(loginUser);
       try {
            String username = loginUser.getUsername();
            String password = loginUser.getPassword();

            UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(username, password);
            //it authenticates if user already exists or not;
            //if user exits it gets successfully authenticated and execution goes to line 52
            this.authenticationManager.authenticate(user);

        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            System.out.println("User invalid");
            throw new Exception("Bad Credentials");
        }catch (BadCredentialsException e) {
            e.printStackTrace();
            throw new Exception("Bad Credentials");
        }
            catch(Exception e){
                e.printStackTrace();
                throw new Exception("myException");
            }


        //fine area...
        //if user successfully authenticated then we get the UserDetails for the user and generate token for him
        UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(loginUser.getUsername());
        String generatedToken = this.jwtUtil.generateToken(userDetails);
        System.out.println("JWT" + generatedToken);
        return ResponseEntity.ok(new JwtResponse(generatedToken));
    }

    @RequestMapping({"/hello"})
    public String firstPage() {
        return "Hello World";
    }

    @GetMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getAddressBookData() {
        List<AddressBookData> addressBookList = null;
        addressBookList = addressBookService.getAddressBookData();
        ResponseDTO responseDTO = new ResponseDTO("Get call Success !!!", addressBookList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping(value = {"/get/{personId}"})
    public ResponseEntity<ResponseDTO> getAddressBookDataById(@PathVariable String personId) {
        AddressBookData addressBookData = addressBookService.getAddressBookDataById(personId);
        ResponseDTO responseDTO = new ResponseDTO("Success Call for Person Id!!!", addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping(value = {"/get/sortbycity/comparator"})
    public ResponseEntity<ResponseDTO> getSortedAddressBookDataByCityUsingComparator() {
        List<AddressBookData> addressBookList = addressBookService.sortAddressBookDataByComparator();
        ResponseDTO responseDTO = new ResponseDTO("Success Call for city!!!", addressBookList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping(value = {"/get/sortbycity"})
    public ResponseEntity<ResponseDTO> getContactsByCityUsingOrderBy() {
        List<AddressBookData> addressBookDataList = addressBookService.sortContactsByCityOrderBy();
        ResponseDTO responseDTO = new ResponseDTO("Success call for City!!!", addressBookDataList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/sortbycity/{city}")
    public ResponseEntity<ResponseDTO> getContactsByCity(@PathVariable("city") String city) {
        List<AddressBookData> addressBookList = null;
        addressBookList = addressBookService.sortContactsByCity(city);
        ResponseDTO responseDTO = new ResponseDTO("Get Call For ID Department Successful", addressBookList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping(value = {"/get/sortbystate/comparator"})
    public ResponseEntity<ResponseDTO> getSortedAddressBookDataByStateUsingComparator() {
        List<AddressBookData> addressBookList = addressBookService.sortAddressBookDataStateByComparator();
        ResponseDTO responseDTO = new ResponseDTO("Success Call for state!!!", addressBookList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping(value = {"/get/sortbystate"})
    public ResponseEntity<ResponseDTO> getContactsByStateUsingOrderBy() {
        List<AddressBookData> addressBookDataList = addressBookService.sortContactsByStateOrderBy();
        ResponseDTO responseDTO = new ResponseDTO("Success call for State!!!", addressBookDataList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/sortbystate/{state}")
    public ResponseEntity<ResponseDTO> getContactsByState(@PathVariable("state") String state) {
        List<AddressBookData> addressBookList = null;
        addressBookList = addressBookService.sortContactsByState(state);
        ResponseDTO responseDTO = new ResponseDTO("Get Call For ID Department Successful", addressBookList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping(value = {"/create"})
    public ResponseEntity<ResponseDTO> createAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = addressBookService.createAddressBookData(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Data ADDED Successfully!!!", addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping(value = {"/update/{personId}"})
    public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable String personId,
                                                             @Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = addressBookService.updateAddressBookData(personId, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Data UPDATED Successfully!!!", addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = {"/delete/{personId}"})
    public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable String personId) {
        addressBookService.deleteAddressBookData(personId);
        ResponseDTO responseDTO = new ResponseDTO("Data DELETED Successfully!!!",
                "ID number: " + personId + " DELETED!!!");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}