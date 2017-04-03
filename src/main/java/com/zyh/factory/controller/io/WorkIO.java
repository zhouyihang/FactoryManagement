package com.zyh.factory.controller.io;

import com.zyh.factory.entity.OrderEntity;
import com.zyh.factory.entity.WorkEntity;
import com.zyh.factory.transman.TransMessage;

/**
 * @author Yihang
 *
 */
public class WorkIO extends BasicIO {

	private WorkEntity work;
	private OrderEntity order;

	public WorkIO(TransMessage transMessage, WorkEntity work, OrderEntity order) {
		super(transMessage);
		this.work = work;
		this.order = order;
	}

	public WorkIO() {
	}

	public WorkEntity getWork() {
		return work;
	}

	public void setWork(WorkEntity work) {
		this.work = work;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	
}
