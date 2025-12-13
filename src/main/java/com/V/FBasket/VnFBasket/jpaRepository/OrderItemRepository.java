package com.V.FBasket.VnFBasket.jpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.V.FBasket.VnFBasket.model.order.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
