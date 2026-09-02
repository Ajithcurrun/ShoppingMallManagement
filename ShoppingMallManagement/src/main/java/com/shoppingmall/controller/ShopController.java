
package com.shoppingmall.controller;
import com.shoppingmall.entity.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.shoppingmall.entity.Employee;
import com.shoppingmall.entity.Shop;
import com.shoppingmall.service.IShopService;

@RestController
@RequestMapping("/api/shops")
public class ShopController {

    private final IShopService shopService;

    public ShopController(IShopService shopService) {
        this.shopService = shopService;
    }

    // Create a new shop
    @PostMapping
    public ResponseEntity<Shop> addShop(@RequestBody Shop shop) {
        return ResponseEntity.ok(shopService.addShop(shop));
    }

    // Search shop by ID
    @GetMapping("/{id}")
    public ResponseEntity<Shop> searchShopById(@PathVariable int id) {

        Shop shop = shopService.searchShopById(id);

        if (shop == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(shop);
    }

    // Update shop
    @PutMapping
    public ResponseEntity<Shop> updateShop(@RequestBody Shop shop) {
        return ResponseEntity.ok(shopService.updateShop(shop));
    }

    // Delete shop
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShop(@PathVariable int id) {

        Boolean deleted = shopService.deleteShop(id);

        if (deleted) {
            return ResponseEntity.ok("Shop deleted successfully");
        }

        return ResponseEntity.notFound().build();
    }
    
 // Add employee
 @PostMapping("/employees")
 public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
     shopService.addEmployee(employee);
     return ResponseEntity.ok(employee);
 }

 // Update employee
 @PutMapping("/employees")
 public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
     shopService.updateEmployee(employee);
     return ResponseEntity.ok(employee);
 }
 
 @PostMapping("/items")
 public ResponseEntity<Item> addItem(@RequestBody Item item) {
     return ResponseEntity.ok(shopService.addItem(item));
 }
 
}
