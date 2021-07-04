package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.modelo.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {

	
}
