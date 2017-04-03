package com.zyh.factory.controller.io;

import com.zyh.factory.entity.OrderEntity;
import com.zyh.factory.transman.TransMessage;

/**
 * @author Yihang
 *
 */
public class OrderIO extends BasicIO {

	private OrderEntity order;

	public OrderIO(TransMessage transMessage, OrderEntity order) {
		super(transMessage);
		this.order = order;
	}

	public OrderIO() {
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	
}
