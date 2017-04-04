package com.zyh.factory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zyh.factory.controller.io.WorkIO;
import com.zyh.factory.entity.OrderEntity;
import com.zyh.factory.entity.WorkEntity;
import com.zyh.factory.repositories.OrderRepository;
import com.zyh.factory.repositories.WorkRepository;
import com.zyh.factory.service.WorkService;
import com.zyh.factory.transman.TransMessage;


@RestController
@RequestMapping(value = "/work")
public class WorkController {

    @Autowired
    WorkRepository workRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    WorkService workService;

    @RequestMapping(method = RequestMethod.POST)
    public WorkIO create(@RequestBody WorkIO workIO) {
    	if (workIO.getTransMessage() == null) {
    		workIO.setTransMessage(new TransMessage());
    	}
    	TransMessage message = workIO.getTransMessage();
    	OrderEntity order = orderRepository.findOne(workIO.getOrder().getOrderId());
    	if (order == null) {
    		message.doSetError("order Id not found");
    		return workIO;
    	}
//    	workIO.getWork().setOrder(order);
    	WorkEntity work = workService.create(workIO.getTransMessage(), workIO.getWork());
    	if(workIO.getTransMessage().shouStop()) {
    		return workIO;
    	}
    	work.setOrder(order);
    	workRepository.save(work);
        return workIO;
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Iterable<WorkEntity> works() {
        return workRepository.findAll();
    }

    @RequestMapping(value = "/{workId}", method = RequestMethod.GET)
    public WorkEntity work(@PathVariable long workId) {
        return workRepository.findOne(workId);
    }
}
