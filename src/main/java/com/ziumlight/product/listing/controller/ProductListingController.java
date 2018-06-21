package com.ziumlight.product.listing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ziumlight.helper.RestPreconditions;
import com.ziumlight.product.listing.model.ProductListingVO;
import com.ziumlight.product.listing.service.ProductListingService;

@RestController
@RequestMapping(value = "/product/listing")
public class ProductListingController {
	private ProductListingService productListingService;
	
	@Autowired
	public ProductListingController(ProductListingService productListingService) {
		this.productListingService = productListingService;
	}
	
	/*@RequestMapping(value= {""}, method = RequestMethod.GET)
	@ResponseBody
	public List<ProductListingVO> allProductListing() {
		return productListing(null);
	}*/
	
	@RequestMapping(value= {"", "{category}","{category}/{subcategory}"}, method = RequestMethod.GET)
	@ResponseBody
	public List<ProductListingVO> productListing(@PathVariable(name = "category", required = false) String categoryName, @PathVariable(name = "subcategory", required = false) String subCategoryName) {
		List<ProductListingVO> productListingList = productListingService.getProductListing(categoryName);
		return RestPreconditions.checkFound(productListingList);
	}
}
