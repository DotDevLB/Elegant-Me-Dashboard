package com.elegant.me.server.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elegant.me.server.Models.ItemDiscount;

@Repository
public interface ItemDiscountRepository extends JpaRepository<ItemDiscount, Long> {
    // Define custom queries if needed
}
