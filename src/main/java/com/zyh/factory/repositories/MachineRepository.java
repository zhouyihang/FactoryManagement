package com.zyh.factory.repositories;

import org.springframework.data.repository.CrudRepository;

import com.zyh.factory.entity.MachineEntity;

public interface MachineRepository extends CrudRepository<MachineEntity, String> {

}