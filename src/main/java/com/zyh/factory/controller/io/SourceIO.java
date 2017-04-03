package com.zyh.factory.controller.io;

import com.zyh.factory.entity.SourceEntity;
import com.zyh.factory.transman.TransMessage;

/**
 * @author Yihang
 *
 */
public class SourceIO extends BasicIO {

	private SourceEntity source;

	public SourceIO(TransMessage transMessage, SourceEntity source) {
		super(transMessage);
		this.source = source;
	}

	public SourceIO() {
	}

	public SourceEntity getSource() {
		return source;
	}

	public void setSource(SourceEntity source) {
		this.source = source;
	}

	
}
