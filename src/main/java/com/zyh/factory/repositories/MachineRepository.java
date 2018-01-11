package com.zyh.factory.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.zyh.factory.entity.MachineEntity;

public interface MachineRepository extends CrudRepository<MachineEntity, Long> {

	@Query("select new map(count(v) as count, v.machineStatus as label) from MachineEntity v group by v.machineStatus")
	public List<?> countGroupByMachineStatus();
	
}
