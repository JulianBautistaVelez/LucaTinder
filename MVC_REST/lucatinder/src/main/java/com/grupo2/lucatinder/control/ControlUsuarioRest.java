package com.grupo2.lucatinder.control;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.grupo2.lucatinder.model.Usuario;
import com.grupo2.lucatinder.service.ServiceGenerico;


/**
 * Clase ControlUsuarioRest
 *
 * Contiene métodos para Usuario
 *
 * @author Sisa,
 
 */


@RestController
public class ControlUsuarioRest {


	@Autowired
	private ServiceGenerico<Usuario> service;
	/**
	 * Crea un Usuario 
	 * 
	 * @return
	 *         <ul>
	 *         <li>ResponseEntity.created(location).build();</li>
	 *         </ul>
	 */
	@PostMapping
	ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario){
		Usuario result = service.crear(usuario);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(result.getId())
				.toUri();
		return ResponseEntity.created(location).build();		
	}
		 
	
	
	
	

}