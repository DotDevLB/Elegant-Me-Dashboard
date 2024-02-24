package com.elegant.me.server.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elegant.me.server.Models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // You can add custom query methods if needed
}

