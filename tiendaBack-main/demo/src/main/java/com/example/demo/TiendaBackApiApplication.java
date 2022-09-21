 package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.controller.UsuarioController;
import com.example.demo.domain.model.Usuario;
import com.example.demo.service.UsuarioService;

@SpringBootApplication
public class TiendaBackApiApplication implements CommandLineRunner {
	public static final Logger log = LoggerFactory.getLogger(TiendaBackApiApplication.class);
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(TiendaBackApiApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		log.info("Encoding password '0luyrZ' => '{}'", passwordEncoder.encode("0luyrZ") );
	}
}

