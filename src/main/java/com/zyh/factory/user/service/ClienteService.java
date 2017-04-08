package com.zyh.factory.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.factory.user.model.Cliente;
import com.zyh.factory.user.repository.ClienteRepository;

/**
 * 
 * @author franck
 *
 */
@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente save(Cliente cliente){
		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> getAll(){
		return clienteRepository.findAll();
	}
	
	public Cliente getById(Long id){
		return clienteRepository.findOne(id);
	}
	
	public List<Cliente> findByNome(String nome){
		return clienteRepository.findByNomeStartingWithIgnoreCase(nome);
	}
	
	public void delete(Cliente cliente){
		clienteRepository.delete(cliente);
	}
	
	public Cliente update(Cliente cliente){
		return clienteRepository.save(cliente);
	}
}
