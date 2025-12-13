package com.V.FBasket.VnFBasket.controller;

import com.V.FBasket.VnFBasket.model.Address;
import com.V.FBasket.VnFBasket.model.User;
import com.V.FBasket.VnFBasket.serviceImpl.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressServiceImpl addressService;

    @PostMapping("user/{userId}/address")
    public ResponseEntity<Address> addAddress(@PathVariable Long userId, @RequestBody Address address) {
        Address savedAddress = addressService.addAddress(userId, address);
        if(savedAddress != null) {
            return new ResponseEntity<>(address, HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/address/user/{userId}")
    public ResponseEntity<List<Address>> getAllAddressesByUserID(@PathVariable long userId) {
        List<Address> addressList = addressService.getAllAddressByUserID(userId);
        if(addressList != null) {
            return new ResponseEntity<>(addressList, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/address/{addressId}")
    public ResponseEntity<Address> getAddressById(@PathVariable long addressId) {
        Address address = addressService.getAddressById(addressId);
        if (address != null) {
            return new ResponseEntity<>(address, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/address/{addressId}")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address, @PathVariable long addressId) {
        Address updatedAddress = addressService.updateAddress(address, addressId);
        if (updatedAddress != null) {
            return new ResponseEntity<>(updatedAddress, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/address/{addressId}")
    public ResponseEntity<Address> deleteAddress(@PathVariable long addressId) {
        Address address = addressService.getAddressById(addressId);
        if(address!=null && addressService.deleteAddress(addressId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
