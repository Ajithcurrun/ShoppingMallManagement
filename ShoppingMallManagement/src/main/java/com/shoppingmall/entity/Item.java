package com.shoppingmall.entity;

import java.time.LocalDate;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Item {

    @Id
    private long id;

    private String name;
    private LocalDate manufacturing;
    private LocalDate expiry;
    private float price;
    private String category;
    @ManyToOne
    private Shop shop;
    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getManufacturing() {
        return manufacturing;
    }

    public void setManufacturing(LocalDate manufacturing) {
        this.manufacturing = manufacturing;
    }

    public LocalDate getExpiry() {
        return expiry;
    }

    public void setExpiry(LocalDate expiry) {
        this.expiry = expiry;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
