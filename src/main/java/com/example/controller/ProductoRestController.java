package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.modelo.Producto;
import com.example.service.ProductoServiceImp;


@RestController
@RequestMapping("/producto")
public class ProductoRestController {

	@Autowired
	private ProductoServiceImp productoService;
	
	@PostMapping(value = "/agregar", produces = "aplication/json")
	public ResponseEntity<Producto> addProducto(@RequestBody Producto producto){
		try {
			System.out.println(producto.getNombre_produc() + " " + producto.getPrecio());
			productoService.save(producto);
			return new ResponseEntity<Producto>(HttpStatus.CREATED);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());	
			return new ResponseEntity<Producto>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping(value = "/getAll", produces = "application/json")
	public ResponseEntity<List<Producto>> getAllProductos(){
		List <Producto> producto = productoService.getAllProducto();
		if(!producto.isEmpty()) {
			return new ResponseEntity<List<Producto>>(producto, HttpStatus.OK);
		}
		return new ResponseEntity<List<Producto>>(HttpStatus.BAD_REQUEST);
	}
	
}
