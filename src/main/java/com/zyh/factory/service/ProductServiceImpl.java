package com.zyh.factory.service;

import org.springframework.stereotype.Service;

import com.zyh.factory.entity.ProductEntity;
import com.zyh.factory.entity.ProductSourceEntity;
import com.zyh.factory.transman.TransMessage;

/**
 * @author Yihang
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Override
	public ProductEntity create(TransMessage message, ProductEntity product) {
		if (message == null) {
			message = new TransMessage();
			message.doSetError("message group missing.");
			return product;
		}
		if (product == null) {
			message.doSetError("product group missing.");
			return product;
		}
		if (product.getProductSource() != null) {
			for (ProductSourceEntity s: product.getProductSource()) {
				s.setProduct(product);
			}
		}
		return product;
	}

}
