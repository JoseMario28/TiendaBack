package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.domain.model.Producto;
import com.example.demo.domain.model.Usuario;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.base.BaseService;

@Service
public class ProductoService extends BaseService<Producto, Integer, ProductoRepository>{

}
