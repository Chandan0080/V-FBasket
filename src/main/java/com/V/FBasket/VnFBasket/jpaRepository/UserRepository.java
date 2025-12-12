package com.V.FBasket.VnFBasket.jpaRepository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.V.FBasket.VnFBasket.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

} 
