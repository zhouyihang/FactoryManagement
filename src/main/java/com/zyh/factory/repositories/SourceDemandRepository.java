package com.zyh.factory.repositories;

import org.springframework.data.repository.CrudRepository;
import com.zyh.factory.entity.SourceDemandEntity;

/**
 * @author Yihang
 *
 */
public interface SourceDemandRepository extends CrudRepository<SourceDemandEntity, Long> {

	public Iterable<SourceDemandEntity> findByOrderId(long orderId);
	
	public Iterable<SourceDemandEntity> findByWorkId(long workId);

	public Iterable<SourceDemandEntity> findBySourceId(long sourceId);
	
	public Iterable<SourceDemandEntity> findBySourceName(String sourceName);
	
	public Iterable<SourceDemandEntity> findBySourceNameAndSourceColor(String sourceName, String sourceColor);
}
