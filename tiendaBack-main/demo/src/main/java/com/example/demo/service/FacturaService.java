package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.domain.model.Factura;
import com.example.demo.domain.model.Usuario;
import com.example.demo.repository.FacturaRepository;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.base.BaseService;

@Service
public class FacturaService extends BaseService<Factura, Integer, FacturaRepository>{

}
