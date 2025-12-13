package com.V.FBasket.VnFBasket.service;

import java.util.List;

import com.V.FBasket.VnFBasket.model.Address;


public interface AddressService {

    Address addAddress(Long userId, Address address);
    List<Address> getAllAddressByUserID(Long userId);
    Address getAddressById(Long addressId);
    Address updateAddress(Address address, Long addressId);
    boolean deleteAddress(Long addressId);
}
