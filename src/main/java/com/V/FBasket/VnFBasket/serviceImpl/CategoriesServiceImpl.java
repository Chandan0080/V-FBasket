package com.V.FBasket.VnFBasket.serviceImpl;

import com.V.FBasket.VnFBasket.jpaRepository.CategoriesRepository;
import com.V.FBasket.VnFBasket.model.Categories;
import com.V.FBasket.VnFBasket.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public Categories addCategory(Categories category) {
        try {
            return categoriesRepository.save(category);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Categories getCategoryById(Long categoryId) {
        try {
            return categoriesRepository.findById(categoryId).get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Categories updateCategory(Categories category, Long categoryId) {
        return null;
    }

    @Override
    public boolean deleteCategory(Long categoryId) {
        try {
            categoriesRepository.deleteById(categoryId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
