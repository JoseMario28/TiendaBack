package com.example.demo.domain.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categorias")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer category_id;
	
	@Column(nullable = false)
	private String name;


	@OneToMany(mappedBy="category",  cascade = CascadeType.ALL)
	private List<Producto> products;
	
	public Categoria(Integer id, String name) {
		super();
		this.category_id = id;
		this.name = name;

	}

	public Categoria() {
		super();
	}

	public Integer getId() {
		return category_id;
	}

	public void setId(Integer id) {
		this.category_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public int hashCode() {
		return Objects.hash(category_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(category_id, other.category_id);
	}

	@Override
	public String toString() {
		return "Categoria [id=" + category_id + ", name=" + name + ", products="+ "]";
	}

	
	
	
	
	

}