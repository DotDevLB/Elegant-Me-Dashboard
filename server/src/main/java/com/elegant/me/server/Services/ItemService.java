package com.elegant.me.server.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import com.elegant.me.server.Models.Item;
import com.elegant.me.server.Repos.ItemRepository;


@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // public List<Item> getAllItems() {
    //     return itemRepository.findAll();
    // }
public Page<Item> getAllItems(int page) {
        return itemRepository.findAll(PageRequest.of(page, 10));
    }
    public Item getItemById(Long itemId) {
        return itemRepository.findById(itemId).orElse(null);
    }

    public Item saveItem(Item item) {
        // You can perform any additional logic before saving
        return itemRepository.save(item);
    }

    public void deleteItem(Long itemId) {
        itemRepository.deleteById(itemId);
    }
    public Item updateItem(Long itemId, Item newItemData) {
        Item existingItem = itemRepository.findById(itemId).orElse(null);
        if (existingItem != null) {
            // Update the existing item with the new data
            existingItem.setName(newItemData.getName());
            existingItem.setCategoryId(newItemData.getCategoryId());
            existingItem.setBrand(newItemData.getBrand());
            existingItem.setSize(newItemData.getSize());
            existingItem.setColor(newItemData.getColor());
            existingItem.setPurchasePrice(newItemData.getPurchasePrice());
            existingItem.setSellingPrice(newItemData.getSellingPrice());
            existingItem.setQuantityInStock(newItemData.getQuantityInStock());
            
            return itemRepository.save(existingItem);
        } else {
            return null;
        }
    }

    public Page<Item> getAllSortedItems(int page, Integer categoryId, String sortDirection) {
        Pageable pageable;
    
        if ("asc".equalsIgnoreCase(sortDirection)) {
            pageable = PageRequest.of(page, 8, Sort.by("sellingPrice").ascending());
        } else if ("desc".equalsIgnoreCase(sortDirection)) {
            pageable = PageRequest.of(page, 8, Sort.by("sellingPrice").descending());
        } else {
            pageable = PageRequest.of(page, 8);
        }
    
        if (categoryId != null) {
            return itemRepository.findByCategoryId(categoryId, pageable);
        } else {
            return itemRepository.findAll(pageable);
        }
    }
    
}
