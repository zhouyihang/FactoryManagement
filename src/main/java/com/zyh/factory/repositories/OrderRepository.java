package com.zyh.factory.repositories;

import org.springframework.data.repository.CrudRepository;

import com.zyh.factory.entity.OrderEntity;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {

	Iterable<OrderEntity> findByOrderStatus(String orderStatus);

}
