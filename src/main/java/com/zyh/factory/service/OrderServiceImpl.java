package com.zyh.factory.service;

import org.springframework.stereotype.Service;

import com.zyh.factory.entity.OrderEntity;
import com.zyh.factory.transman.TransMessage;

/**
 * @author Yihang
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Override
	public OrderEntity create(TransMessage message, OrderEntity order) {
		if (message == null) {
			message = new TransMessage();
			message.doSetError("message group missing.");
			return order;
		}
		if (order == null) {
			message.doSetError("order group missing.");
			return order;
		}
		return order;
	}

}
