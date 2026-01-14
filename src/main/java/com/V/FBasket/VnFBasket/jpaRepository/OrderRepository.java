package com.V.FBasket.VnFBasket.jpaRepository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.V.FBasket.VnFBasket.model.Orders;

import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

<<<<<<< HEAD
    @Query("""
    SELECT o FROM Orders o
    JOIN FETCH o.address
    WHERE o.user.userId = :userId
    """)
=======
    @Query("SELECT o FROM Orders o WHERE o.user.userId = :userId")
>>>>>>> b4871f231d5d188be037be991650d8136bfa0a99
    List<Orders> findByUserId(@Param("userId") Long userId);

}
