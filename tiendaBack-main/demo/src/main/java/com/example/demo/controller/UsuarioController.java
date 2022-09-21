package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@Autowired
	private UsuarioRepository repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("")
	public Page<Usuario> all(){
		return service.findAll( PageRequest.of(0, 10) );
	}

	@GetMapping("page/{pageNumber}")
	public Page<Usuario> getByPage(@PathVariable Integer pageNumber) {
		return service.findAll(
				PageRequest.of(pageNumber, 10)
		);
	}
	
	@GetMapping("email")
	public Usuario getEmail(@RequestParam String email){
		return repo.findByEmail(email);
	}

	@GetMapping("{id}")
	public Usuario get(@PathVariable Integer id){
		return service.findById(id);
	}
	
	
	@PostMapping("")
	public Usuario create(@RequestBody Usuario usuario) {
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		return service.save(usuario);
	}
	
	@PutMapping("{id}")
	public Usuario update(@PathVariable Integer id, @RequestBody Usuario usuario) {
		Usuario usuarioDB = service.findById(id);

		if (usuarioDB != null) {
			usuarioDB.setName(usuario.getName());
			usuarioDB.setEmail(usuario.getEmail());
			usuarioDB.setPassword(passwordEncoder.encode(usuario.getPassword()));
			usuarioDB.setRole(usuario.getRole());

			return service.save(usuarioDB);
		}

		return null;

	}
	
	@DeleteMapping("{id}")
	public void borrarUsuario(@PathVariable Integer id) {
		service.deleteById(id);
	}

}

