package com.V.FBasket.VnFBasket.serviceImpl;

import com.V.FBasket.VnFBasket.jpaRepository.AddressRepository;
import com.V.FBasket.VnFBasket.model.Address;
import com.V.FBasket.VnFBasket.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address addAddress(Address address, Long userId) {
        return null;
    }

    @Override
    public List<Address> getAllAddressesByUserID(Long userId) {
        return List.of();
    }

    @Override
    public Address getAddressById(Long addressId) {
        return null;
    }

    @Override
    public Address updateAddress(Address address, Long addressId) {
        return null;
    }

    @Override
    public boolean deleteAddress(Long addressId) {

    }


}
