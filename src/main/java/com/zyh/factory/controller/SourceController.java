package com.zyh.factory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zyh.factory.controller.io.SourceIO;
import com.zyh.factory.entity.SourceEntity;
import com.zyh.factory.repositories.SourceRepository;
import com.zyh.factory.service.SourceService;
import com.zyh.factory.transman.TransMessage;


/**
 * @author Yihang
 *
 */
@RestController
@RequestMapping(value = "/source")
public class SourceController {

    @Autowired
    SourceRepository sourceRepository;
    @Autowired
    SourceService sourceService;

    @RequestMapping(method = RequestMethod.POST)
    public SourceIO create(@RequestBody SourceIO sourceIO) {
    	if (sourceIO.getTransMessage() == null) {
    		sourceIO.setTransMessage(new TransMessage());
    	}
    	SourceEntity source = sourceService.create(sourceIO.getTransMessage(), sourceIO.getSource());
    	if(sourceIO.getTransMessage().shouStop()) {
    		return sourceIO;
    	}
    	sourceRepository.save(source);
        return sourceIO;
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Iterable<SourceEntity> sources() {
        return sourceRepository.findAll();
    }

    @RequestMapping(value = "/{sourceId}", method = RequestMethod.GET)
    public SourceEntity source(@PathVariable long sourceId) {
        return sourceRepository.findOne(sourceId);
    }
}
