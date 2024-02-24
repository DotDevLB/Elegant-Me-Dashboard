package com.elegant.me.server.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import com.elegant.me.server.Models.Item;
import com.elegant.me.server.Services.ItemService;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // @GetMapping
    // public List<Item> getAllItems() {
    //     return itemService.getAllItems();
    // }

    @GetMapping("/all")
    public Page<Item> getAllItems(@RequestParam(defaultValue = "0") int page) {
        return itemService.getAllItems(page);
    }

    @GetMapping("/{itemId}")
    public Item getItemById(@PathVariable Long itemId) {
        return itemService.getItemById(itemId);
    }

    @PostMapping
    public Item saveItem(@RequestBody Item item) {
        return itemService.saveItem(item);
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@PathVariable Long itemId) {
        itemService.deleteItem(itemId);
    }
    @PutMapping("/{itemId}")
    public ResponseEntity<Item> updateItem(@PathVariable Long itemId, @RequestBody Item newItemData) {
        Item updatedItem = itemService.updateItem(itemId, newItemData);
        if (updatedItem != null) {
            return ResponseEntity.ok(updatedItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
public Page<Item> getAllFilteredAndSortedItems(@RequestParam(defaultValue = "0") int page,
                                                @RequestParam(required = false) Integer categoryId,
                                                @RequestParam(defaultValue = "asc") String sortDirection) {
    return itemService.getAllSortedItems(page, categoryId, sortDirection);
}

}






















