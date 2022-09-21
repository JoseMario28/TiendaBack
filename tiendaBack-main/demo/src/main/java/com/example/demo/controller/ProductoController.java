package com.example.demo.controller;

import java.util.List;
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

import com.example.demo.domain.model.Producto;
import com.example.demo.domain.model.Usuario;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.service.ProductoService;
import com.example.demo.service.UsuarioService;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private ProductoRepository repo;
	
	@GetMapping("")
	public Page<Producto> all(){
		return productoService.findAll( PageRequest.of(0, 10) );
	}
	
	@GetMapping("todos")
	public List<Producto> allC(){
		return productoService.findAll(  );
	}

	@GetMapping("page/{pageNumber}")
	public Page<Producto> getByPage(@PathVariable Integer pageNumber) {
		return productoService.findAll(
				PageRequest.of(pageNumber, 10)
		);
	}

	@GetMapping("{id}")
	public Producto get(@PathVariable Integer id){
		return productoService.findById(id);
	}
	
	@GetMapping("name")
	public Producto getName(@RequestParam String name){
		return repo.findByName(name);
	}
	
	
	
	@PostMapping("")
	public Producto create(@RequestBody Producto producto) {
		return productoService.save(producto);
	}
	
	@PutMapping("{id}")
	public Producto update(@PathVariable Integer id, @RequestBody Producto product) {
		Producto productooDB = productoService.findById(id);

		if (productooDB != null) {
			productooDB.setName(product.getName());
			productooDB.setPrice(product.getPrice());
			productooDB.setInStock(product.getInStock());
			productooDB.setImage(product.getImage());
			productooDB.setCategory(product.getCategory());

			return productoService.save(productooDB);
		}

		return null;

	}
	
	@DeleteMapping("{id}")
	public void borrarUsuario(@PathVariable Integer id) {
		productoService.deleteById(id);
	}

}
