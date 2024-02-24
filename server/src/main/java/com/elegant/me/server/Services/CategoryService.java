package com.elegant.me.server.Services;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;  
import org.springframework.stereotype.Service;

import com.elegant.me.server.Models.Category;
import com.elegant.me.server.Models.User;
import com.elegant.me.server.Repos.CategoryRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Integer categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    public Category saveCategory(Category category) {
        // You can perform any additional logic before saving
        return categoryRepository.save(category);
    }

    public void deleteCategory(Integer categoryId) {
        categoryRepository.deleteById(categoryId);
    }


  public Page<Category> getCategoriesByPage(int page) {
        return categoryRepository.findAll(PageRequest.of(page, 8));
    }

    public Category updateCategory(Integer categoryId, Category category) {
    Category existingCategory = categoryRepository.findById(categoryId).orElse(null);
    if (existingCategory != null) {
        existingCategory.setCategoryName(category.getCategoryName());
        existingCategory.setDescription(category.getDescription());
        existingCategory.setGender(category.getGender());
        return categoryRepository.save(existingCategory);
    }
    return null;
}

}


