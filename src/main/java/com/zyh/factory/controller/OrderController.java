package com.zyh.factory.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zyh.factory.controller.io.OrderIO;
import com.zyh.factory.entity.OrderEntity;
import com.zyh.factory.entity.ProductSourceEntity;
import com.zyh.factory.entity.WorkEntity;
import com.zyh.factory.repositories.OrderRepository;
import com.zyh.factory.repositories.ProductRepository;
import com.zyh.factory.service.OrderService;
import com.zyh.factory.transman.TransMessage;


@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
//    @Autowired
//    ProductSourceRepository productSourceRepository;
    @Autowired
    OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    public OrderEntity create(@RequestBody OrderEntity order, HttpServletResponse res) {
    	OrderIO orderIO = new OrderIO();
    	System.out.println("create order ");
    	if (orderIO.getTransMessage() == null) {
    		orderIO.setTransMessage(new TransMessage());
    	}
//    	OrderEntity order = orderService.create(orderIO.getTransMessage(), orderIO.getOrder());
    	orderService.create(orderIO.getTransMessage(), order);
    	if(orderIO.getTransMessage().shouStop()) {
    		res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    		return order;
    	}
    	if (order.getOrderWorks() != null) {
    		for (WorkEntity work : order.getOrderWorks()) {
    			work.setOrder(order);
    		}
    	}
    	for (WorkEntity w : order.getOrderWorks()) {
    		if (w.getProduct() != null && w.getProduct().getProductId() == 0 ) {
    			if (w.getProduct().getProductSource() != null) {
//    				System.out.println("save producsource");
    				for (ProductSourceEntity e: w.getProduct().getProductSource()) {
    					e.setProduct(w.getProduct());
    				}    				
				}
//    			System.out.println("save product");
    			productRepository.save(w.getProduct());
    		}
    	}
    	orderRepository.save(order);
        return order;
    }
    
    @RequestMapping(value = "/{orderId}", method = RequestMethod.POST)
    public OrderEntity updateOrder(@PathVariable long orderId, @RequestBody OrderEntity order, 
    		HttpServletResponse res) {
    	System.out.println("update order "+orderId);
    	TransMessage message = new TransMessage();
        //OrderEntity orderOld = orderRepository.findOne(orderId);
    	orderService.update(message, order);
    	order.setOrderId(orderId);
    	if(message.shouStop()) {
    		res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    		return order;
    	}
    	orderRepository.save(order);
        return order;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<OrderEntity> orders() {
        return orderRepository.findAll();
    }

    @RequestMapping(value = "/summary/{orderStatus}", method = RequestMethod.GET)
    public Long orderSummary(@PathVariable String orderStatus) {
        return orderRepository.countByOrderStatus(orderStatus);
    }
    
    @RequestMapping(value = "/summary", method = RequestMethod.GET)
    public List<?> orderSummary() {
//        return orderRepository.countGroupByOrderStatus();
    	return orderRepository.countGroupByMonth();
    }
    
    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    public OrderEntity order(@PathVariable long orderId) {
        return orderRepository.findOne(orderId);
    }
    
//    @RequestMapping(method = RequestMethod.GET)
//    public Iterable<OrderEntity> orderByStatus(@RequestParam String orderStatus) {
//        return orderRepository.findByOrderStatus(orderStatus);
//    }
}
