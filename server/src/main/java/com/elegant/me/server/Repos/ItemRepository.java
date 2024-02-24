package com.elegant.me.server.Repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.elegant.me.server.Models.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Page<Item> findByCategoryId(Integer categoryId, Pageable pageable);
}

