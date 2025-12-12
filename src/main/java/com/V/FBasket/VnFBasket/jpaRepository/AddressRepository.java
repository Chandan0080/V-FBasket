package com.V.FBasket.VnFBasket.jpaRepository;

import com.V.FBasket.VnFBasket.model.Address;
import com.V.FBasket.VnFBasket.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
    public Optional<Users> findByUserId(Long userId);
}
