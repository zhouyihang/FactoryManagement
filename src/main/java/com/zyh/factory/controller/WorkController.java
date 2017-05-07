package com.zyh.factory.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    public WorkEntity create(@RequestBody WorkEntity work, HttpServletResponse res) {
    	System.out.println("create work ");
    	TransMessage message = new TransMessage();
//    	OrderEntity order = orderRepository.findOne(orderId);
//    	if (order == null) {
//    		message.doSetError("order Id not found");
//    		return work;
//    	}
//    	workIO.getWork().setOrder(order);
    	workService.create(message, work);
    	if(message.shouStop()) {
    		return work;
    	}
//    	work.setOrder(order);
    	workRepository.save(work);
        return work;
    }
    
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public WorkEntity create(@RequestBody WorkEntity work, 
    		@RequestParam("order") long orderId, HttpServletResponse res) {
    	System.out.println("create work requestparm");
    	TransMessage message = new TransMessage();
    	OrderEntity order = orderRepository.findOne(orderId);
    	if (order == null) {
    		message.doSetError("order Id not found");
    		return work;
    	}
//    	workIO.getWork().setOrder(order);
    	workService.create(message, work);
    	if(message.shouStop()) {
    		return work;
    	}
    	work.setOrder(order);
    	workRepository.save(work);
        return work;
    }
    
    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.POST)
    public WorkEntity createWithOrder(@RequestBody WorkEntity work, 
    		@PathVariable long orderId, HttpServletResponse res) {
    	System.out.println("create work with order ");
    	TransMessage message = new TransMessage();
    	OrderEntity order = orderRepository.findOne(orderId);
    	if (order == null) {
    		message.doSetError("order Id not found");
    		return work;
    	}
//    	workIO.getWork().setOrder(order);
    	workService.create(message, work);
    	if(message.shouStop()) {
    		return work;
    	}
    	work.setOrder(order);
    	workRepository.save(work);
        return work;
    }
    
    @RequestMapping(value = "/{workId}", method = RequestMethod.POST)
    public WorkEntity updateWork(@PathVariable long workId, @RequestBody WorkEntity work, 
    		HttpServletResponse res) {
    	TransMessage message = new TransMessage();
        //WorkEntity workOld = workRepository.findOne(workId);
    	workService.udate(message, work);
    	work.setWorkId(workId);
    	if(message.shouStop()) {
    		res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    		return work;
    	}
    	workRepository.save(work);
        return work;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<WorkEntity> works() {
        return workRepository.findAll();
    }

    @RequestMapping(value = "/{workId}", method = RequestMethod.GET)
    public WorkEntity work(@PathVariable long workId) {
        return workRepository.findOne(workId);
    }
}
