package com.V.FBasket.VnFBasket.service;

import com.V.FBasket.VnFBasket.model.Address;
import com.V.FBasket.VnFBasket.model.User;

import java.util.List;

public interface AddressService {

    Address addAddress(Long userId, Address address);
//    List<Address> getAllAddressesByUserID(Long userId);
    Address getAddressById(Long addressId);
    Address updateAddress(Address address, Long addressId);
    boolean deleteAddress(Long addressId);
}
