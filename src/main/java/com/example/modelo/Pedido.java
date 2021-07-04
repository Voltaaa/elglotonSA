package com.example.modelo;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Setter @AllArgsConstructor @NoArgsConstructor
public class Pedido {

	@Id
	@Column()
	private Integer id;
	
	@Column()
	private String direccion;
	
	@Column()
	@Enumerated(EnumType.ORDINAL)
	private EstadoPedido estado;
	
	@ManyToMany(mappedBy = "pedidos")
	private List<Producto> productos;
	
	@ManyToOne
	private Cliente cliente;
	
	
	public enum EstadoPedido{
		GENERADO,PAGADO,ENVIADO
		// GENERAR MAS
	}
}


