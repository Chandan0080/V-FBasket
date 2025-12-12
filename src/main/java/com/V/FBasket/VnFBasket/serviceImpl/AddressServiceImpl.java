package com.V.FBasket.VnFBasket.serviceImpl;

import com.V.FBasket.VnFBasket.jpaRepository.AddressRepository;
import com.V.FBasket.VnFBasket.jpaRepository.UserRepository;
import com.V.FBasket.VnFBasket.model.Address;
import com.V.FBasket.VnFBasket.model.User;
import com.V.FBasket.VnFBasket.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepo;

    @Autowired
    private UserRepository userRepo;

    @Override
    public Address addAddress(Long userId, Address address) {
        User u1 = userRepo.findById(userId).orElse(null);
        address.setUser(u1);
        return addressRepo.save(address);
    }

//    @Override
//    public List<Address> getAllAddressesByUserID(Long userId) {
//
//        return addressRepo.findByUserUserId(userId);
//    }

    @Override
    public Address getAddressById(Long addressId) {
        return addressRepo.findById(addressId).orElse(null);
    }

    @Override
    public Address updateAddress(Address address, Long addressId) {
        return null;
    }

    @Override
    public boolean deleteAddress(Long addressId) {
        Optional<Address> opt = addressRepo.findById(addressId);
        if (opt.isEmpty()) return false;
        addressRepo.deleteById(addressId);
        return true;
    }


}
