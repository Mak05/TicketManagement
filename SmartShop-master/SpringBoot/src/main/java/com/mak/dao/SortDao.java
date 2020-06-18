package com.mak.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mak.model.Product;

public interface SortDao extends PagingAndSortingRepository<Product, Integer> {

}
