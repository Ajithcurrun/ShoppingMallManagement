
package com.shoppingmall.service;

import com.shoppingmall.entity.Employee;
import com.shoppingmall.entity.Item;
import com.shoppingmall.entity.Shop;

public interface IShopService {

    Shop addShop(Shop shop);

    Shop updateShop(Shop shop);

    Shop searchShopById(int id);

    Boolean addEmployee(Employee employee);

    Boolean updateEmployee(Employee employee);

    Boolean deleteShop(int id);

    Item addItem(Item item);
}

