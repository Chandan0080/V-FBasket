package com.V.FBasket.VnFBasket.service;

import com.V.FBasket.VnFBasket.model.Categories;

public interface CategoriesService {

    Categories addCategory(Categories category);
    Categories getCategoryById(Long categoryId);
    Categories updateCategory(Categories category, Long categoryId);
    boolean deleteCategory(Long categoryId);
}
