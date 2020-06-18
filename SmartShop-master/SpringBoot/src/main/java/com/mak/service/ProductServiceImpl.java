package com.mak.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mak.dao.InventoryDao;
import com.mak.model.Product;

@Service
public class ProductServiceImpl implements ProductServiceIntf {

	private static final Logger logger = LogManager.getLogger(ProductServiceImpl.class);

	@Autowired
	InventoryDao productDao;

	public void addProduct(Product product) {
		logger.info("Add Product Service");
		productDao.save(product);
	}

	public List<Product> listProducts() {
		logger.info("List Product Service");
		List<Product> productList = (List<Product>) productDao.findAll();
		return productList;
	}

	@Override
	public Optional<Product> getById(int id) {
		logger.info("Get Product Service");
		return productDao.findById(id);
	}

	@Override
	public void removeProduct(int id) {
		logger.info("Remove Product Service");
		productDao.deleteById(id);
	}
}
