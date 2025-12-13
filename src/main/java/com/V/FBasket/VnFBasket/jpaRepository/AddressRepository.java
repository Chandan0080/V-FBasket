package com.V.FBasket.VnFBasket.jpaRepository;

import com.V.FBasket.VnFBasket.model.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {


}
