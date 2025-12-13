package com.V.FBasket.VnFBasket.jpaRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.V.FBasket.VnFBasket.model.order.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // get all orders of a user
    List<Order> findByUserId(Long userId);
}
