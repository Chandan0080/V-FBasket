package com.V.FBasket.VnFBasket.jpaRepository;

import com.V.FBasket.VnFBasket.model.Address;
import com.V.FBasket.VnFBasket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

    @Query("select a from Address a where a.user.userId = :userId")
    List<Address> findAddressByUserId(@Param("userId") Long userId);

}
