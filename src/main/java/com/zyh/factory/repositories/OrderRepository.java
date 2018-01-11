package com.zyh.factory.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.zyh.factory.entity.OrderEntity;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {

	Iterable<OrderEntity> findByOrderStatus(String orderStatus);
	Long countByOrderStatus(String orderStatus);
	@Query("select new map(count(v) as count, v.orderStatus as label) from OrderEntity v group by v.orderStatus")
	public List<?> countGroupByOrderStatus();
//	@Query("select new map(extract(year from expectDeliverDate) as yr, extract(month from expectDeliverDate) as mon, " +
//    " count(*) as count) " +
//    " from OrderEntity " +
//    " group by extract(year from expectDeliverDate), extract(month from expectDeliverDate) " +
//    " order by yr, mon")
	@Query("select new map(to_char(expectDeliverDate, 'YYYY-MM') as label, count(*) as count) " +
		    " from OrderEntity " +
			" where orderStatus != 'completed' " +
		    " group by to_char(expectDeliverDate, 'YYYY-MM') " +
		    " order by label")
	public List<?> countActiveGroupByMonth();
	@Query("select new map(to_char(expectDeliverDate, 'YYYY-MM') as label, count(*) as count) " +
		    " from OrderEntity " +
			" where orderStatus = 'completed' " +
		    " group by to_char(expectDeliverDate, 'YYYY-MM') " +
		    " order by label")
	public List<?> countCompletedGroupByMonth();

}
