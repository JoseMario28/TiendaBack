package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.domain.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.service.base.BaseService;

@Service
public class ClienteService extends BaseService<Cliente, Integer, ClienteRepository>{

}
