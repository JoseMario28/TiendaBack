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

import com.example.demo.domain.model.Categoria;
import com.example.demo.domain.model.Cliente;
import com.example.demo.domain.model.Producto;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoriaController {
	
	@Autowired
	private CategoriaService service;
	
	@Autowired
	private CategoriaRepository repo;
	
	@GetMapping("")
	public Page<Categoria> all(){
		return service.findAll( PageRequest.of(0, 10) );
	}
	
	@GetMapping("page/{pageNumber}")
	public Page<Categoria> getByPage(@PathVariable Integer pageNumber) {
		return service.findAll(
				PageRequest.of(pageNumber, 10)
		);
	}
	
	@GetMapping("{id}")
	public Categoria get(@PathVariable Integer id){
		return service.findById(id);
	}
	
	@GetMapping("name")
	public Categoria getName(@RequestParam String name){
		return repo.findByName(name);
	}
	
	
	@PostMapping("")
	public Categoria create(@RequestBody Categoria category) {
		return service.save(category);
	}
	
	@PutMapping("{id}")
	public Categoria update(@PathVariable Integer id, @RequestBody Categoria category) {
		Categoria categoriaDB = service.findById(id);

		if (categoriaDB != null) {
			categoriaDB.setName(category.getName());
			//categoriaDB.setProducts(category.getProducts());

			return service.save(categoriaDB);
		}

		return null;

	}
	
	
	@DeleteMapping("{id}")
	public void borrarCategoria(@PathVariable Integer id) {
		service.deleteById(id);
	}

}
