package com.ziumlight.product.listing.service;

import java.util.List;

import com.ziumlight.product.listing.model.ProductListingVO;

public interface ProductListingService {

	List<ProductListingVO> getProductListing(String categoryName);

}
