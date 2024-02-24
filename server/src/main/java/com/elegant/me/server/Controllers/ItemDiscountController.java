package com.elegant.me.server.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.elegant.me.server.Models.ItemDiscount;
import com.elegant.me.server.Services.ItemDiscountService;

import java.util.List;

@RestController
@RequestMapping("/api/item-discounts")
public class ItemDiscountController {

    @Autowired
    private ItemDiscountService itemDiscountService;

    @GetMapping
    public ResponseEntity<List<ItemDiscount>> getAllItemDiscounts() {
        List<ItemDiscount> itemDiscounts = itemDiscountService.getAllItemDiscounts();
        return new ResponseEntity<>(itemDiscounts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDiscount> getItemDiscountById(@PathVariable("id") Long id) {
        ItemDiscount itemDiscount = itemDiscountService.getItemDiscountById(id);
        if (itemDiscount != null) {
            return new ResponseEntity<>(itemDiscount, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ItemDiscount> createItemDiscount(@RequestBody ItemDiscount itemDiscount) {
        ItemDiscount createdItemDiscount = itemDiscountService.createItemDiscount(itemDiscount);
        return new ResponseEntity<>(createdItemDiscount, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItemDiscount(@PathVariable("id") Long id) {
        itemDiscountService.deleteItemDiscount(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
