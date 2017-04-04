package com.zyh.factory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zyh.factory.controller.io.SourceDemandIO;
import com.zyh.factory.entity.OrderEntity;
import com.zyh.factory.entity.SourceDemandEntity;
import com.zyh.factory.entity.SourceEntity;
import com.zyh.factory.entity.WorkEntity;
import com.zyh.factory.repositories.OrderRepository;
import com.zyh.factory.repositories.SourceDemandRepository;
import com.zyh.factory.repositories.SourceRepository;
import com.zyh.factory.repositories.WorkRepository;
import com.zyh.factory.service.SourceDemandService;
import com.zyh.factory.transman.TransMessage;


/**
 * @author Yihang
 *
 */
@RestController
@RequestMapping(value = "/sourcedemand")
public class SourceDemandController {

    @Autowired
    SourceDemandRepository sourceDemandRepository;
    @Autowired
    SourceDemandService sourceDemandService;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    WorkRepository workRepository;
    @Autowired
    SourceRepository sourceRepository;

    @RequestMapping(method = RequestMethod.POST)
    public SourceDemandIO create(@RequestBody SourceDemandIO sourceDemandIO) {
    	if (sourceDemandIO.getTransMessage() == null) {
    		sourceDemandIO.setTransMessage(new TransMessage());
    	}
    	TransMessage message = sourceDemandIO.getTransMessage();
    	OrderEntity order = orderRepository.findOne(sourceDemandIO.getSourceDemand().getOrderId());
    	if (order == null) {
    		message.doSetError("order Id not found");
    		return sourceDemandIO;
    	}
    	WorkEntity work = workRepository.findOne(sourceDemandIO.getSourceDemand().getWorkId());
    	if (work == null) {
    		message.doSetError("work Id not found");
    		return sourceDemandIO;
    	}
    	SourceEntity source = sourceRepository.findOne(sourceDemandIO.getSourceDemand().getSourceId());
    	if (source == null) {
    		message.doSetError("source Id not found");
    		return sourceDemandIO;
    	}
    	SourceDemandEntity sourceDemand = sourceDemandService.create(sourceDemandIO.getTransMessage(), 
    			sourceDemandIO.getSourceDemand(), order, work, source);
    	if(sourceDemandIO.getTransMessage().shouStop()) {
    		return sourceDemandIO;
    	}
    	sourceDemandRepository.save(sourceDemand);
        return sourceDemandIO;
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Iterable<SourceDemandEntity> sourceDemands() {
        return sourceDemandRepository.findAll();
    }

    @RequestMapping(value = "/{sourceDemandId}", method = RequestMethod.GET)
    public SourceDemandEntity sourceDemand(@PathVariable long sourceDemandId) {
        return sourceDemandRepository.findOne(sourceDemandId);
    }
    
    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET)
    public Iterable<SourceDemandEntity> sourceByOrder(@PathVariable long orderId) {
        return sourceDemandRepository.findByOrderId(orderId);
    }
    
    @RequestMapping(value = "/work/{workId}", method = RequestMethod.GET)
    public Iterable<SourceDemandEntity> sourceByWork(@PathVariable long workId) {
        return sourceDemandRepository.findByWorkId(workId);
    }
    
    @RequestMapping(value = "/source/{sourceId}", method = RequestMethod.GET)
    public Iterable<SourceDemandEntity> sourceBySourceId(@PathVariable long sourceId) {
        return sourceDemandRepository.findBySourceId(sourceId);
    }
    
}
