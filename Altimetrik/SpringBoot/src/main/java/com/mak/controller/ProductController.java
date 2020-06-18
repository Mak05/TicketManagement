package com.mak.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mak.exception.RecordNotFoundException;
import com.mak.model.Product;
import com.mak.service.ProductServiceIntf;
import com.mak.service.ProductSortIntf;

/**
 * @author MaK
 *
 */
@RestController
public class ProductController {

	private static final Logger logger = LogManager.getLogger(ProductController.class);

	@Autowired
	ProductServiceIntf productService;

	@Autowired
	ProductSortIntf productSort;

	/**
	 * @param map
	 * @return
	 */
	@RequestMapping(value = { "/", "/home" })
	public ModelAndView homePage(Map<String, Object> map, Model model) {
		logger.info("Home Controller");
		try {
			List<Product> productList = productService.listProducts();
			if (productList.size() == 0) {
				throw new RecordNotFoundException();
			}
			map.put("productList", productList);
		} catch (RecordNotFoundException e) {
			model.addAttribute("message", e.getMessage());
		}
		return new ModelAndView("home");
	}

	/**
	 * @param inventory
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/products")
	public ModelAndView addInventory(@ModelAttribute("product") Product product, Map<String, Object> map, Model model) {
		logger.info("Products Controller");
		try {
			List<Product> productList = productService.listProducts();
			if (productList.size() == 0) {
				throw new RecordNotFoundException();
			}
			map.put("productList", productList);
		} catch (RecordNotFoundException e) {
			model.addAttribute("message", e.getMessage());
		}
		return new ModelAndView("addInventory");
	}

	/**
	 * @param product
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/productSort")
	public ModelAndView sortProduct(@ModelAttribute("product") Product product, Map<String, Object> map,
			@RequestParam String sort, Model model) {
		logger.info("Sort Controller");
		try {
			List<Product> sortedProduct = (List<Product>) productSort.sortProducts(sort);
			if (sortedProduct.size() == 0) {
				throw new RecordNotFoundException();
			}
			map.put("productList", sortedProduct);
		} catch (RecordNotFoundException e) {
			model.addAttribute("message", e.getMessage());
		}
		return new ModelAndView("home");
	}

	/**
	 * @param product
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/product")
	public ModelAndView editProduct(@ModelAttribute("product") Product product, @RequestParam int id, Model model) {
		logger.info("Edit Product");
		try {
			product = productService.getById(id).get();
			if (product == null) {
				throw new RecordNotFoundException(id);
			}
		} catch (RecordNotFoundException e) {
			model.addAttribute("message", e.getMessage());
		}
		return new ModelAndView("edit", "product", product);
	}

	/**
	 * @param inventory
	 * @param map
	 * @param theBindingResult
	 * @return
	 */
	@RequestMapping(value = "/inventory", method = RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute("product") Product product, Map<String, Object> map, Model model) {
		logger.info("Inserting the Product Details");
		try {
			product.setDate(new Date());
			productService.addProduct(product);
			List<Product> productList = productService.listProducts();
			if (productList.size() == 0) {
				throw new RecordNotFoundException();
			}
			map.put("productList", productList);
		} catch (RecordNotFoundException e) {
			model.addAttribute("message", e.getMessage());
		}
		return new ModelAndView("home");

	}

	/**
	 * @param request
	 * @param product
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public ModelAndView updateProduct(Model model, @ModelAttribute("product") Product product,
			Map<String, Object> map) {
		logger.info("Update Controller");
		try {
			product.setDate(new Date());
			productService.addProduct(product);
			List<Product> productList = productService.listProducts();
			if (productList.size() == 0) {
				throw new RecordNotFoundException();
			}
			map.put("productList", productList);
		} catch (RecordNotFoundException e) {
			model.addAttribute("message", e.getMessage());
		}
		return new ModelAndView("home");
	}

	/**
	 * @param product
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/sold")
	public ModelAndView soldProduct(Product product, Map<String, Object> map, Model model, @RequestParam int id, @RequestParam int quantity) {
		logger.info("Sold Controller");
		try {
			product = productService.getById(id).get();
			product.setsDate(new Date());
			int quan = product.getQuantity() - quantity;
			if (quan > 0) {
				product.setQuantity(quan);
				productService.addProduct(product);
			} else {
				productService.removeProduct(id);
			}
			List<Product> productList = productService.listProducts();
			if (productList.size() == 0) {
				throw new RecordNotFoundException();
			}
			map.put("productList", productList);
		} catch (RecordNotFoundException e) {
			model.addAttribute("message", e.getMessage());
		}
		return new ModelAndView("home");
	}

	/**
	 * @param product
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/sale")
	public ModelAndView sellProduct(@ModelAttribute("product") Product product, Model model, @RequestParam int id) {
		logger.info("Sell Product");
		try {
			product = productService.getById(id).get();
			if (product == null) {
				throw new RecordNotFoundException(id);
			}
		} catch (RecordNotFoundException e) {
			model.addAttribute("message", e.getMessage());
		}
		return new ModelAndView("sale", "product", product);
	}

}
