package com.zyh.factory.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.factory.user.model.Usuario;
import com.zyh.factory.user.repository.UserRepository;

/**
 * 
 * @author franck
 *
 */
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public Usuario save(Usuario user) {
		return userRepository.save(user);
	}
	
	/**
	 * 
	 * @param user
	 */
	public void remove(Usuario user) {
		userRepository.delete(user);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Usuario> findAll(){
		return userRepository.findAll();
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Usuario findById(Long id) {
		return userRepository.getOne(id);
	}
	
	/**
	 * 
	 * @param userName
	 * @return
	 */
	public Optional<Usuario> findByName(String userName) {
		return userRepository.findByUserName(userName);
	}

}
