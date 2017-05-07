package com.zyh.factory.controller.io;


import com.zyh.factory.entity.OrderEntity;
import com.zyh.factory.entity.WorkEntity;

/**
 * @author Yihang
 *
 */
public class WorkIO { //extends WorkEntity {

	private OrderEntity order;

	public WorkIO(WorkEntity work, OrderEntity order) {
		super();
		this.order = order;
	}

	public WorkIO() {
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	
}
