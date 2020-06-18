package com.mak.service;

import java.util.List;
import java.util.Optional;

import com.mak.model.Product;

public interface ProductServiceIntf {

	public void addProduct(Product b);

	public List<Product> listProducts();

	public Optional<Product> getById(int id);

	public void removeProduct(int id);

}
