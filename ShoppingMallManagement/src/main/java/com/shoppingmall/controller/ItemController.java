package com.shoppingmall.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shoppingmall.entity.Item;
import com.shoppingmall.service.IItemService;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final IItemService itemService;

    public ItemController(IItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> searchItemById(@PathVariable long id) {

        Item item = itemService.searchItemById(id);

        if (item == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(item);
    }

    @PutMapping
    public ResponseEntity<Item> updateItem(@RequestBody Item item) {
        return ResponseEntity.ok(itemService.updateItem(item));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable long id) {

        Boolean deleted = itemService.deleteItem(id);

        if (deleted) {
            return ResponseEntity.ok("Item deleted successfully");
        }

        return ResponseEntity.notFound().build();
    }
}