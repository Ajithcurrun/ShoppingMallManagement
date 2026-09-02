package com.shoppingmall.service.impl;

import org.springframework.stereotype.Service;

import com.shoppingmall.entity.Item;
import com.shoppingmall.repository.IItemRepository;
import com.shoppingmall.service.IItemService;

@Service
public class ItemServiceImpl implements IItemService {

    private final IItemRepository itemRepository;

    public ItemServiceImpl(IItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item updateItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item searchItemById(long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean deleteItem(long id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
            return true;
        }

        return false;
    }
}