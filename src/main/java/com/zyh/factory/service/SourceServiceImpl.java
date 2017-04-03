package com.zyh.factory.service;

import org.springframework.stereotype.Service;

import com.zyh.factory.entity.SourceEntity;
import com.zyh.factory.transman.TransMessage;

/**
 * @author Yihang
 *
 */
@Service
public class SourceServiceImpl implements SourceService {

	@Override
	public SourceEntity create(TransMessage message, SourceEntity source) {
		if (message == null) {
			message = new TransMessage();
			message.doSetError("message group missing.");
			return source;
		}
		if (source == null) {
			message.doSetError("source group missing.");
			return source;
		}
		return source;
	}

}
