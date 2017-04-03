package com.zyh.factory.repositories;

import org.springframework.data.repository.CrudRepository;
import com.zyh.factory.entity.WorkEntity;

public interface WorkRepository extends CrudRepository<WorkEntity, String> {

}