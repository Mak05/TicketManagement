package com.mak.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mak.dao.SortDao;
import com.mak.model.Product;

@Service
public class ProductSortImpl implements ProductSortIntf {

	private static final Logger logger = LogManager.getLogger(ProductSortImpl.class);

	@Autowired
	SortDao sortDao;

	@Override
	public List<Product> sortProducts(String str) {
		logger.info("Sorting Product Service");
		return (List<Product>) sortDao.findAll(Sort.by(str));
	}

}
