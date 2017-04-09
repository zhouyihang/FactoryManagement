package com.zyh.factory.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zyh.factory.controller.io.OrderIO;
import com.zyh.factory.entity.OrderEntity;
import com.zyh.factory.repositories.OrderRepository;
import com.zyh.factory.service.OrderService;
import com.zyh.factory.transman.TransMessage;


@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    public OrderEntity create(@RequestBody OrderEntity order, HttpServletResponse res) {
    	OrderIO orderIO = new OrderIO();
    	if (orderIO.getTransMessage() == null) {
    		orderIO.setTransMessage(new TransMessage());
    	}
//    	OrderEntity order = orderService.create(orderIO.getTransMessage(), orderIO.getOrder());
    	orderService.create(orderIO.getTransMessage(), order);
    	if(orderIO.getTransMessage().shouStop()) {
    		res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    		return order;
    	}
    	orderRepository.save(order);
        return order;
    }
    
    @RequestMapping(value = "/{orderId}", method = RequestMethod.POST)
    public OrderEntity updateOrder(@PathVariable long orderId, @RequestBody OrderEntity order, 
    		HttpServletResponse res) {
    	TransMessage message = new TransMessage();
        //OrderEntity orderOld = orderRepository.findOne(orderId);
    	orderService.create(message, order);
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

    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    public OrderEntity order(@PathVariable long orderId) {
        return orderRepository.findOne(orderId);
    }
    
//    @RequestMapping(method = RequestMethod.GET)
//    public Iterable<OrderEntity> orderByStatus(@RequestParam String orderStatus) {
//        return orderRepository.findByOrderStatus(orderStatus);
//    }
}
