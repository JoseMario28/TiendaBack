package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.model.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura,Integer>{


}
