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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.model.Cliente;
import com.example.demo.domain.model.Usuario;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.service.ClienteService;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@Autowired
	private ClienteRepository repo;
	
	@GetMapping("")
	public Page<Cliente> all(){
		return service.findAll( PageRequest.of(0, 10) );
	}
	
	@GetMapping("page/{pageNumber}")
	public Page<Cliente> getByPage(@PathVariable Integer pageNumber) {
		return service.findAll(
				PageRequest.of(pageNumber, 10)
		);
	}
	
	@GetMapping("email")
	public Cliente getEmail(@RequestParam String email){
		return repo.findByEmail(email);
	}
	
	
	@GetMapping("{id}")
	public Cliente get(@PathVariable Integer id){
		return service.findById(id);
	}
	
	
	@PostMapping("")
	public Cliente create(@RequestBody Cliente client) {
		return service.save(client);
	}
	
	@PutMapping("{id}")
	public Cliente update(@PathVariable Integer id, @RequestBody Cliente client) {
		Cliente clienteDB = service.findById(id);

		if (clienteDB != null) {
			clienteDB.setName(client.getName());
			clienteDB.setSurname(client.getSurname());
			clienteDB.setEmail(client.getEmail());
			clienteDB.setCountry(client.getCountry());
			clienteDB.setDateOfBirth(client.getDateOfBirth());
			clienteDB.setInvoices(client.getInvoices());




			return service.save(client);
		}

		return null;

	}
	
	@DeleteMapping("{id}")
	public void borrarCliente(@PathVariable Integer id) {
		service.deleteById(id);
	}

}
