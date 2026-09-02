package com.shoppingmall.service;

import com.shoppingmall.entity.Item;

public interface IItemService {

    Item addItem(Item item);

    Item updateItem(Item item);

    Item searchItemById(long id);

    Boolean deleteItem(long id);
}