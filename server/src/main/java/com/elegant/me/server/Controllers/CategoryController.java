package com.elegant.me.server.Controllers;


import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.elegant.me.server.Models.Category;
import com.elegant.me.server.Services.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{categoryId}")
    public Category getCategoryById(@PathVariable Integer categoryId) {
        return categoryService.getCategoryById(categoryId);
    }
    @GetMapping("/paged")
    public Page<Category> getAllCategories(
            
            @RequestParam(defaultValue = "0") int page
    ) {
        return categoryService.getCategoriesByPage(page);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable Integer categoryId) {
        categoryService.deleteCategory(categoryId);
    }
    
    @PutMapping("/{categoryId}")
public ResponseEntity<Category> updateCategory(@PathVariable Integer categoryId, @RequestBody Category category) {
    Category updatedCategory = categoryService.updateCategory(categoryId, category);
    if (updatedCategory != null) {
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

}

