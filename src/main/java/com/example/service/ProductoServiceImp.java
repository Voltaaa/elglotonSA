package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.modelo.Producto;
import com.example.repo.ProductoRepository;

@Service
public class ProductoServiceImp {
	
	@Autowired
	private ProductoRepository repo;

	public List<Producto> getAllProducto(){
		return repo.findAll();
	}
	
	@Transactional
	public void save(Producto produc) throws Exception{
		if(produc == null) {
			throw new Exception();
		}
		try {
			repo.save(produc);
		}catch(DataAccessException e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	
}
