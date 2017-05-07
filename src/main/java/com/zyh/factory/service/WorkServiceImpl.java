package com.zyh.factory.service;

import org.springframework.stereotype.Service;

import com.zyh.factory.entity.WorkEntity;
import com.zyh.factory.transman.TransMessage;

/**
 * @author Yihang
 *
 */
@Service
public class WorkServiceImpl implements WorkService {

	@Override
	public WorkEntity create(TransMessage message, WorkEntity work) {
		if (message == null) {
			message = new TransMessage();
			message.doSetError("message group missing.");
			return work;
		}
		if (work == null) {
			message.doSetError("work group missing.");
			return work;
		}
		work.setWorkStatus("new");
		return work;
	}

	@Override
	public WorkEntity udate(TransMessage message, WorkEntity work) {
		if (message == null) {
			message = new TransMessage();
			message.doSetError("message group missing.");
			return work;
		}
		if (work == null) {
			message.doSetError("work group missing.");
			return work;
		}
		return work;
	}

}
