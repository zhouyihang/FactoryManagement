package com.zyh.factory.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.zyh.factory.entity.SourceEntity;

public interface SourceRepository extends CrudRepository<SourceEntity, Long> {

	@Query("select new map(count(v) as count, v.sourceStatus as label) from SourceEntity v group by v.sourceStatus")
	public List<?> countGroupBySourceStatus();
}
