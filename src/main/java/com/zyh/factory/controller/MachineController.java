package com.zyh.factory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zyh.factory.entity.MachineEntity;
import com.zyh.factory.repositories.MachineRepository;

@RestController
public class MachineController {

    @Autowired
    MachineRepository machineRepository;

    @RequestMapping(value = "/machines", method = RequestMethod.GET)
    public Iterable<MachineEntity> machines() {
        return machineRepository.findAll();
    }

    @RequestMapping(value = "/machines/{machineId}", method = RequestMethod.GET)
    public MachineEntity machine(@PathVariable String machineId) {
        return machineRepository.findOne(machineId);
    }
}
