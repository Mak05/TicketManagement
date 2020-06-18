package com.mak.test;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mak.dao.InventoryDao;
import com.mak.model.Product;
import com.mak.service.ProductServiceImpl;
import com.mak.service.ProductSortImpl;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestBeanConfig.class })
public class ProductControllerTest {

	@Autowired
	ProductServiceImpl service;
	
	@Autowired
	Product product;
	
	@Autowired
	ProductSortImpl sortService;
	
	@Mock
	InventoryDao dao;

	@Test
	public void productDataTest(){
		product = new Product();
		product.setName("tiger");
		product.setDescription("tiger");
		product.setQuantity(10);
		product.setDate(new Date());
		product.setsPrice(200.00);
		product.setPrice(100.00);
		service.addProduct(product);
	}
	
	@Test
	public void addProductTest() {
		service.addProduct(product);
		List<Product> productList = service.listProducts();
		for (Product prod : productList) {
			Assert.assertEquals("tiger", prod.getName());
		}
	}

	@Test
	public void updateProductTest() {
		product.setDescription("tiger crunch");
		service.addProduct(product);	
		Assert.assertEquals("tiger crunch", dao.findById(1).get().getDescription());
	}

	@Test
	public void soldProductTest(){
		product.setsDate(new Date());
		int quan = product.getQuantity() - 5;
		product.setQuantity(quan);
		service.addProduct(product);
		Assert.assertTrue(dao.findById(1).get().getQuantity()>0);
	}
	
	@Test
	public void removeProductTest(){
		service.removeProduct(1);
		Assert.assertNull(dao.findById(1).get());
	}
	
	@Test
	public void sortProductTest(){
		List<Product> sortedProduct = (List<Product>) sortService.sortProducts("name");
		for (Product prod : sortedProduct) {
			Assert.assertEquals("tiger", prod.getName());
		}
	}
}