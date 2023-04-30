package com.spring.LabRecipes.Service;

import com.spring.LabRecipes.Model.Category;
import com.spring.LabRecipes.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElse(null);
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public boolean existsById(Long id) {
        return categoryRepository.existsById(id);
    }

    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    public void delete(Long id) {
        Category category = findById(id);
        if( category != null ) {
            categoryRepository.delete(category);
        }
    }
}
