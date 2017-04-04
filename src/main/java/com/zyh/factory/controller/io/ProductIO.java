package com.zyh.factory.controller.io;

import com.zyh.factory.entity.ProductEntity;
import com.zyh.factory.transman.TransMessage;

/**
 * @author Yihang
 *
 */
public class ProductIO extends BasicIO {

	private ProductEntity product;

	public ProductIO(TransMessage transMessage, ProductEntity product) {
		super(transMessage);
		this.product = product;
	}

	public ProductIO() {
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	
}
