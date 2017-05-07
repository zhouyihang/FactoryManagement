package com.zyh.factory.controller;

import javax.servlet.http.HttpServletResponse;

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
    public SourceEntity create(@RequestBody SourceEntity source, HttpServletResponse res) {
    	SourceIO sourceIO = new SourceIO();
    	if (sourceIO.getTransMessage() == null) {
    		sourceIO.setTransMessage(new TransMessage());
    	}
//    	SourceEntity source = sourceService.create(sourceIO.getTransMessage(), sourceIO.getSource());
    	sourceService.create(sourceIO.getTransMessage(), source);
    	if(sourceIO.getTransMessage().shouStop()) {
    		res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    		return source;
    	}
    	sourceRepository.save(source);
        return source;
    }
    
    @RequestMapping(value = "/{sourceId}", method = RequestMethod.POST)
    public SourceEntity updateSource(@PathVariable long sourceId, @RequestBody SourceEntity source, 
    		HttpServletResponse res) {
    	TransMessage message = new TransMessage();
        //SourceEntity sourceOld = sourceRepository.findOne(sourceId);
    	sourceService.update(message, source);
    	source.setSourceId(sourceId);
    	if(message.shouStop()) {
    		res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    		return source;
    	}
    	sourceRepository.save(source);
        return source;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<SourceEntity> sources() {
        return sourceRepository.findAll();
    }

    @RequestMapping(value = "/{sourceId}", method = RequestMethod.GET)
    public SourceEntity source(@PathVariable long sourceId) {
        return sourceRepository.findOne(sourceId);
    }
}
