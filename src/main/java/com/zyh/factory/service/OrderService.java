package com.zyh.factory.service;

import com.zyh.factory.entity.OrderEntity;
import com.zyh.factory.transman.TransMessage;

/**
 * @author Yihang
 *
 */
public interface OrderService {

	OrderEntity create(TransMessage transMessage, OrderEntity order);

}
