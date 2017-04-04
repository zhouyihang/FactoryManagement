package com.zyh.factory.controller.io;

import com.zyh.factory.entity.SourceDemandEntity;
import com.zyh.factory.transman.TransMessage;

/**
 * @author Yihang
 *
 */
public class SourceDemandIO extends BasicIO {

	private SourceDemandEntity sourceDemand;

	public SourceDemandIO(TransMessage transMessage, SourceDemandEntity sourceDemand) {
		super(transMessage);
		this.sourceDemand = sourceDemand;
	}

	public SourceDemandIO() {
	}

	public SourceDemandEntity getSourceDemand() {
		return sourceDemand;
	}

	public void setSourceDemand(SourceDemandEntity sourceDemand) {
		this.sourceDemand = sourceDemand;
	}

	
}
