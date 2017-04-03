package com.zyh.factory.controller.io;

import com.zyh.factory.transman.TransMessage;

/**
 * @author Yihang
 *
 */
public abstract class BasicIO {

	private TransMessage transMessage;

	public BasicIO() {
	}

	public BasicIO(TransMessage transMessage) {
		this.transMessage = transMessage;
	}

	public TransMessage getTransMessage() {
		return transMessage;
	}

	public void setTransMessage(TransMessage transMessage) {
		this.transMessage = transMessage;
	}
	
	
}
