package com.ziumlight.product.listing.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ziumlight.dao.ProductDAO;
import com.ziumlight.helper.GeneralUtils;
import com.ziumlight.product.listing.model.ProductListingVO;
import com.ziumlight.to.ProductTO;
@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class ProductListingServiceImpl implements ProductListingService {
	private ProductDAO productDAO;
	
	@Autowired
	public ProductListingServiceImpl(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Override
	public List<ProductListingVO> getProductListing(String categoryName) {
		List<ProductTO> productTOList = null;
		if(categoryName != null && !categoryName.trim().isEmpty()) {
			
		}else {
			productTOList = productDAO.findByDeleteInd(GeneralUtils.NO_IND);
		}
		return convertToProductListingVO(productTOList);
	}
	
	private List<ProductListingVO> convertToProductListingVO(List<ProductTO> productTOLists){
		List<ProductListingVO> voList = new ArrayList<ProductListingVO>();
		return voList;
	}

}
