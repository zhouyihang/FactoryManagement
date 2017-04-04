package com.zyh.factory.service;

import com.zyh.factory.entity.OrderEntity;
import com.zyh.factory.entity.SourceDemandEntity;
import com.zyh.factory.entity.SourceEntity;
import com.zyh.factory.entity.WorkEntity;
import com.zyh.factory.transman.TransMessage;

/**
 * @author Yihang
 *
 */
public interface SourceDemandService {

	SourceDemandEntity create(TransMessage transMessage, 
			SourceDemandEntity sourceDemand, OrderEntity order, WorkEntity work, SourceEntity source);

}
