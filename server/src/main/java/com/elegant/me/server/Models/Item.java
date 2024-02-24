package com.elegant.me.server.Models;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "name", nullable = false)
    private String name;

   
    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "barcode", length = 50)
    private String barcode;

    @Column(name = "brand", length = 100)
    private String brand;

    @Column(name = "size", length = 20)
    private String size;

    @Column(name = "color", length = 50)
    private String color;

    @Column(name = "purchase_price")
    private BigDecimal purchasePrice;

    @Column(name = "selling_price")
    private BigDecimal sellingPrice;

    @Column(name = "quantity_in_stock")
    private Integer quantityInStock;

    @Column(name = "min_stock_level")
    private Integer minStockLevel;

    @Column(name = "image_url", length = 255)
    private String imageUrl;

    @Column(name = "date_added")
    private Date dateAdded;

    @Column(name = "last_updated")
    private Date lastUpdated;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    // Getters and setters
}
