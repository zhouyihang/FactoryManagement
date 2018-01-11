package com.zyh.factory.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.zyh.factory.entity.WorkEntity;

public interface WorkRepository extends CrudRepository<WorkEntity, Long> {

	@Query("select new map(count(v) as count, v.workStatus as label) from WorkEntity v group by v.workStatus")
	public List<?> countGroupByWorkStatus();
	
}
