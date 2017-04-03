package com.zyh.factory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zyh.factory.controller.io.OrderIO;
import com.zyh.factory.entity.OrderEntity;
import com.zyh.factory.repositories.OrderRepository;
import com.zyh.factory.service.OrderService;


@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    public OrderIO create(@RequestBody OrderIO orderIO) {
    	OrderEntity order = orderService.create(orderIO.getTransMessage(), orderIO.getOrder());
    	if(orderIO.getTransMessage().shouStop()) {
    		return orderIO;
    	}
    	orderRepository.save(order);
        return orderIO;
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Iterable<OrderEntity> orders() {
        return orderRepository.findAll();
    }

    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    public OrderEntity order(@PathVariable long orderId) {
        return orderRepository.findOne(orderId);
    }
}
