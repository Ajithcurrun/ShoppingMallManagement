package com.shoppingmall.service.impl;

import org.springframework.stereotype.Service;

import com.shoppingmall.entity.Employee;
import com.shoppingmall.entity.Item;
import com.shoppingmall.entity.Shop;
import com.shoppingmall.repository.IEmployeeRepository;
import com.shoppingmall.repository.IItemRepository;
import com.shoppingmall.repository.IShopRepository;
import com.shoppingmall.service.IShopService;

@Service
public class ShopServiceImpl implements IShopService {

    private final IShopRepository shopRepository;
    private final IEmployeeRepository employeeRepository;
    private final IItemRepository itemRepository;

    public ShopServiceImpl(
            IShopRepository shopRepository,
            IEmployeeRepository employeeRepository,
            IItemRepository itemRepository) {

        this.shopRepository = shopRepository;
        this.employeeRepository = employeeRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public Shop addShop(Shop shop) {
        return shopRepository.save(shop);
    }

    @Override
    public Shop updateShop(Shop shop) {
        return shopRepository.save(shop);
    }

    @Override
    public Shop searchShopById(int id) {
        return shopRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean addEmployee(Employee employee) {
        employeeRepository.save(employee);
        return true;
    }

    @Override
    public Boolean updateEmployee(Employee employee) {
        employeeRepository.save(employee);
        return true;
    }

    @Override
    public Boolean deleteShop(int id) {
        if (shopRepository.existsById(id)) {
            shopRepository.deleteById(id);
            return true;
        }

        return false;
    }

    @Override
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }
}
