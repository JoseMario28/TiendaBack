package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.model.Factura;
import com.example.demo.domain.model.Usuario;
import com.example.demo.repository.FacturaRepository;
import com.example.demo.service.UsuarioService;

@RestController
@RequestMapping("/facturas")
@CrossOrigin(origins = "http://localhost:4200")
public class FacturaController {

	@Autowired
	private FacturaRepository repository;
	
	
	@GetMapping("")
	public Page<Factura> all(){
		return repository.findAll( PageRequest.of(0, 10) );
	}

	@GetMapping("page/{pageNumber}")
	public Page<Factura> getByPage(@PathVariable Integer pageNumber) {
		return repository.findAll(
				PageRequest.of(pageNumber, 10)
		);
	}

	@GetMapping("{id}")
	public Optional<Factura> get(@PathVariable Integer id){
		return repository.findById(id);
	}
	
	
	
	@PostMapping("")
	public Factura create(@RequestBody Factura factura) {
		return repository.save(factura);
	}
	
	
	@DeleteMapping("{id}")
	public void borrarFactura(@PathVariable Integer id) {
		repository.deleteById(id);
	}
}
