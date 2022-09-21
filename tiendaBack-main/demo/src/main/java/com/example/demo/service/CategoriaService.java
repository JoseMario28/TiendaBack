package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.domain.model.Categoria;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.service.base.BaseService;

@Service
public class CategoriaService extends BaseService<Categoria, Integer, CategoriaRepository>{

}
