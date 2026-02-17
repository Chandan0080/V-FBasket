package com.V.FBasket.VnFBasket.jpaRepository;

import com.V.FBasket.VnFBasket.model.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemsRepository extends JpaRepository<OrderItems, Long> {
}
