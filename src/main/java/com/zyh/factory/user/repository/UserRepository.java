package com.zyh.factory.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zyh.factory.user.model.Usuario;

/**
 * 
 * @author franck
 *
 */
@Repository
public interface UserRepository extends JpaRepository<Usuario, Long>{
	
	public Optional<Usuario> findByUserName(String userName);

}
