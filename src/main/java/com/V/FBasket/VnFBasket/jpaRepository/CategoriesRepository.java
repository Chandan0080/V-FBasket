package com.V.FBasket.VnFBasket.jpaRepository;

import com.V.FBasket.VnFBasket.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories,Long> {

    public Optional<Categories> findByCategoryId(Long categoryId);
}
