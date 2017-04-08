package com.zyh.factory.user.controller;

import java.util.Date;
import java.util.Optional;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zyh.factory.user.model.Usuario;
import com.zyh.factory.user.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 
 * @author franck
 *
 */

@RestController
@RequestMapping(LoginController.BASE_URI)
public class LoginController {
	
	public static final String BASE_URI = "/login";
	
	@Autowired
	private UserService userService;
	
	/**
	 * 
	 * @param user
	 * @return
	 * @throws ServletException
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LoginResponse login(@RequestBody Usuario user) throws ServletException{

		Optional<Usuario> userLogged = userService.findByName(user.getUserName());

		if(!userLogged.isPresent()){
			throw new ServletException("Usuário não encontrado.");
		}
		
		if (!userLogged.get().getPassword().equals(user.getPassword())){
			throw new ServletException("Usuário ou senha inválido.");
		}
		
		String token =  Jwts.builder()
				.setSubject(userLogged.get().getUserName())
				.signWith(SignatureAlgorithm.HS512, "banana")
				.setExpiration(new Date(System.currentTimeMillis() + 1 * 60 * 1000))
				.compact();
		
		
		return	new LoginResponse(token);
		
	}
	
	/**
	 * 
	 * @author franck
	 *
	 */
	private class LoginResponse{
		public String token;
		 
		public LoginResponse(String token ){
			this.token=token; 
		 }
	}
}
