package com.zyh.factory.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.zyh.factory.entity.OrderEntity;
import com.zyh.factory.entity.SourceDemandEntity;
import com.zyh.factory.entity.SourceEntity;
import com.zyh.factory.entity.WorkEntity;
import com.zyh.factory.transman.TransMessage;

@Service
public class SourceDemandServiceImpl implements SourceDemandService {

	@Override
	public SourceDemandEntity create(TransMessage transMessage, 
			SourceDemandEntity sourceDemand, OrderEntity order, WorkEntity work, SourceEntity source) {
		if (sourceDemand.getSourceColor() ==null) {
			transMessage.doSetError("color missing");
			return sourceDemand;
		}
		if (sourceDemand.getQuantity() <= 0) {
			transMessage.doSetError("pls input Quantity.");
			return sourceDemand;
		}
		sourceDemand.setOrderId(order.getOrderId());
		sourceDemand.setDemandStatus("new");
		sourceDemand.setSourceId(source.getSourceId());
		//sourceDemand.setSourceColor();
		//sourceDemand.setQuantity(int quantity)
		sourceDemand.setSourceUnit(source.getSourceUnit());
		sourceDemand.setTotalPrice(source.getPrice().multiply(BigDecimal.valueOf(sourceDemand.getQuantity())));
		sourceDemand.setProviderName(source.getProviderName());
		sourceDemand.setSourceName(source.getSourceName());

		return sourceDemand;
	}

}
