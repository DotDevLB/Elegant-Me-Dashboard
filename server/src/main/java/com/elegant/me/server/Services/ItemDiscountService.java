package com.elegant.me.server.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elegant.me.server.Models.ItemDiscount;
import com.elegant.me.server.Repos.ItemDiscountRepository;

import java.util.List;

@Service
public class ItemDiscountService {

    @Autowired
    private ItemDiscountRepository itemDiscountRepository;

    public List<ItemDiscount> getAllItemDiscounts() {
        return itemDiscountRepository.findAll();
    }

    public ItemDiscount getItemDiscountById(Long id) {
        return itemDiscountRepository.findById(id).orElse(null);
    }

    public ItemDiscount createItemDiscount(ItemDiscount itemDiscount) {
        return itemDiscountRepository.save(itemDiscount);
    }

    public void deleteItemDiscount(Long id) {
        itemDiscountRepository.deleteById(id);
    }
}
