package com.V.FBasket.VnFBasket.jpaRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.V.FBasket.VnFBasket.model.Order.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUserId(Long userId);
}
