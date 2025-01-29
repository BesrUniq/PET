package com.example.forum.service;

import com.example.forum.models.Category;
import com.example.forum.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public List<Category> findAll() {
        List<Category> categories = categoryRepository.findAll();
        System.out.println("Categories: " + categories);
        return categories;
    }


    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);

    }


}

