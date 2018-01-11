package com.zyh.factory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zyh.factory.controller.io.SummaryIO;
import com.zyh.factory.repositories.MachineRepository;
import com.zyh.factory.repositories.OrderRepository;
import com.zyh.factory.repositories.SourceRepository;
import com.zyh.factory.repositories.WorkRepository;
import com.zyh.factory.transman.TransMessage;


@RestController
@RequestMapping(value = "/summary")
public class SummaryController {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    WorkRepository workRepository;
    @Autowired
    SourceRepository sourceRepository;
    @Autowired
    MachineRepository machineRepository;


    @RequestMapping(method = RequestMethod.GET)
    public SummaryIO orders() {
        return new SummaryIO(new TransMessage(), 
        					orderRepository.countGroupByOrderStatus(),
        					workRepository.countGroupByWorkStatus(),
        					sourceRepository.countGroupBySourceStatus(),
        					machineRepository.countGroupByMachineStatus());
    }

}
