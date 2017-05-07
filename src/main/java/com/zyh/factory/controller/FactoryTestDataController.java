package com.zyh.factory.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zyh.factory.controller.io.OrderIO;
import com.zyh.factory.controller.io.SourceDemandIO;
import com.zyh.factory.controller.io.WorkIO;
import com.zyh.factory.entity.OrderEntity;
import com.zyh.factory.entity.SourceDemandEntity;
import com.zyh.factory.entity.WorkEntity;
import com.zyh.factory.transman.TransMessage;

@RestController
@RequestMapping(value = "/testdata")
public class FactoryTestDataController {

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public OrderIO order() {
    	OrderIO orderIO = new OrderIO();
    	orderIO.setOrder(new OrderEntity());
    	orderIO.setTransMessage(new TransMessage());
    	
    	orderIO.getOrder().setOrderStatus("new");
        return orderIO;
    }
    
    @RequestMapping(value = "/work", method = RequestMethod.GET)
    public WorkIO work() {
    	WorkIO workIO = new WorkIO();
//    	workIO.setWork(new WorkEntity());
//    	workIO.setTransMessage(new TransMessage());
    	
//    	workIO.setWorkStatus("new");
        return workIO;
    }
    
    @RequestMapping(value = "/sourcedemand", method = RequestMethod.GET)
    public SourceDemandIO sourceDemand() {
    	SourceDemandIO sourceDemandIO = new SourceDemandIO();
    	sourceDemandIO.setSourceDemand(new SourceDemandEntity());
    	sourceDemandIO.setTransMessage(new TransMessage());
    	
    	sourceDemandIO.getSourceDemand().setDemandStatus("new");
        return sourceDemandIO;
    }
}