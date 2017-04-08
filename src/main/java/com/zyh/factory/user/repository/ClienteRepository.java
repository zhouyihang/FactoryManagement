package com.zyh.factory.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zyh.factory.user.model.Cliente;

/**
 * 
 * @author franck
 *
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	List<Cliente> findByNomeStartingWithIgnoreCase(String nome);

}
