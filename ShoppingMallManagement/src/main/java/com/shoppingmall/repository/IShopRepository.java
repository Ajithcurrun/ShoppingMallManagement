package com.shoppingmall.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingmall.entity.Shop;

public interface IShopRepository extends JpaRepository<Shop, Integer> {

}
