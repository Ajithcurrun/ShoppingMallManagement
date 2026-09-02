
package com.shoppingmall.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingmall.entity.Item;

public interface IItemRepository extends JpaRepository<Item, Long> {

}
