package com.zyh.factory.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zyh.factory.user.model.Cliente;
import com.zyh.factory.user.service.ClienteService;

/**
 * 
 * @author franck
 *
 */
@RestController
@RequestMapping("/admin")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	/**
	 * 
	 * @param cliente
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/clientes")
	public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente) {

		Cliente ClienteSalvo = clienteService.save(cliente);

		return new ResponseEntity<Cliente>(ClienteSalvo, HttpStatus.CREATED);
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/clientes")
	public ResponseEntity<List<Cliente>> getAll() {
		List<Cliente> listClientes = clienteService.getAll();

		return new ResponseEntity<>(listClientes, HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/clientes/{id}")
	public ResponseEntity<Cliente> getById(@PathVariable Long id) {

		Cliente cliente = clienteService.getById(id);
		if (cliente == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}

	/**
	 * 
	 * @param nome
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/clientes/query")
	public ResponseEntity<List<Cliente>> findByNome(@RequestParam("nome") String nome) {
		List<Cliente> listClientes = clienteService.getAll();

		if (nome != null && !nome.trim().isEmpty()) {
			listClientes = this.clienteService.findByNome(nome);
		}

		return new ResponseEntity<>(listClientes, HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/clientes/{id}")
	public ResponseEntity<Cliente> deleteCliente(@PathVariable Long id) {

		Cliente cliente = new Cliente();
		cliente.setId(id);
		clienteService.delete(cliente);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * 
	 * @param cliente
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/clientes")
	public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente) {

		Cliente clienteUpdated = clienteService.update(cliente);

		return new ResponseEntity<>(clienteUpdated, HttpStatus.OK);
	}
}
