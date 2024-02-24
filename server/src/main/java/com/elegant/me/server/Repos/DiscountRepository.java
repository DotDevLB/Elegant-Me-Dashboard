package com.elegant.me.server.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elegant.me.server.Models.Discount;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
    // Define custom queries if needed
}

