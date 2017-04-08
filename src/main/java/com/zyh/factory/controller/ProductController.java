package com.zyh.factory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zyh.factory.controller.io.ProductIO;
import com.zyh.factory.entity.ProductEntity;
import com.zyh.factory.repositories.ProductRepository;
import com.zyh.factory.service.ProductService;
import com.zyh.factory.transman.TransMessage;


@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.POST)
    public ProductIO create(@RequestBody ProductIO productIO) {
    	if (productIO.getTransMessage() == null) {
    		productIO.setTransMessage(new TransMessage());
    	}
    	ProductEntity product = productService.create(productIO.getTransMessage(), productIO.getProduct());
    	if(productIO.getTransMessage().shouStop()) {
    		return productIO;
    	}
    	productRepository.save(product);
        return productIO;
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Iterable<ProductEntity> products() {
        return productRepository.findAll();
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public ProductEntity product(@PathVariable long productId) {
        return productRepository.findOne(productId);
    }
}