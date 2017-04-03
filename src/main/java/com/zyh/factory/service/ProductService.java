package com.zyh.factory.service;

import com.zyh.factory.entity.ProductEntity;
import com.zyh.factory.transman.TransMessage;

/**
 * @author Yihang
 *
 */
public interface ProductService {

	ProductEntity create(TransMessage transMessage, ProductEntity product);

}
