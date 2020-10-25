package com.escalab.controller;

/*import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escalab.dto.ConsultaListaVentaDTO;
import com.escalab.exception.ModeloNotFoundException;
import com.escalab.model.Cliente;
import com.escalab.model.Producto;
import com.escalab.service.IClienteService;

@RestController
@RequestMapping("/cliente")*/
public class ClienteController {

	/*@Autowired
	private IClienteService service;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listar(){
		List<Cliente> lista = service.listar();
		return new ResponseEntity<List<Cliente>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> listarPorId(@PathVariable("id") Integer id){
		Cliente obj = service.leerPorId(id);
		if(obj.getIdCliente() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);  
		}
		return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
	}
	
	public ResponseEntity<Object> registrar(@Valid @RequestBody ConsultaListaVentaDTO consultaDTO){
		Producto obj = service.registrar(consultaDTO);
		
	} */
}


