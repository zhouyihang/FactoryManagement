package com.zyh.factory.controller;

import javax.servlet.http.HttpServletResponse;

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
    public ProductEntity create(@RequestBody ProductEntity product, HttpServletResponse res) {
    	System.out.println("create product ");
    	ProductIO productIO = new ProductIO();
    	if (productIO.getTransMessage() == null) {
    		productIO.setTransMessage(new TransMessage());
    	}
//    	ProductEntity product = productService.create(productIO.getTransMessage(), productIO.getProduct());
    	productService.create(productIO.getTransMessage(), product);
    	if(productIO.getTransMessage().shouStop()) {
    		res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    		return product;
    	}
    	productRepository.save(product);
        return product;
    }
    
    @RequestMapping(value = "/{productId}", method = RequestMethod.POST)
    public ProductEntity updateProduct(@PathVariable long productId, @RequestBody ProductEntity product, 
    		HttpServletResponse res) {
    	System.out.println("update product with id ");
    	TransMessage message = new TransMessage();
        //ProductEntity productOld = productRepository.findOne(productId);
    	productService.update(message, product);
    	product.setProductId(productId);
    	if(message.shouStop()) {
    		res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    		return product;
    	}
    	productRepository.save(product);
        return product;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<ProductEntity> products() {
    	System.out.println("product find all ");
        return productRepository.findAll();
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public ProductEntity product(@PathVariable long productId) {
    	System.out.println("product find by id ");
        return productRepository.findOne(productId);
    }
}