
package com.mak.dao;

import org.springframework.data.repository.CrudRepository;

import com.mak.model.Product;

public interface InventoryDao extends CrudRepository<Product, Integer> {
}
