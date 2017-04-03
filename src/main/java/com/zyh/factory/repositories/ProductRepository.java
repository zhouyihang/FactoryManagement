package com.zyh.factory.repositories;

import org.springframework.data.repository.CrudRepository;
import com.zyh.factory.entity.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

}
