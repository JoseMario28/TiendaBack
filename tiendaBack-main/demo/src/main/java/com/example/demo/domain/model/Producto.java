package com.example.demo.domain.model;


import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer product_id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private double price;
	
	@Column(nullable = false)
	private Integer inStock;
	
	@Column()
	private String image;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Categoria category;

	public Integer getId() {
		return product_id;
	}

	public void setId(Integer id) {
		this.product_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getInStock() {
		return inStock;
	}

	public void setInStock(Integer inStock) {
		this.inStock = inStock;
	}
	

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Categoria getCategory() {
		return category;
	}

	public void setCategory(Categoria category) {
		this.category = category;
	}

	public Producto(Integer id, String name, double price, Integer inStock, Categoria category) {
		super();
		this.product_id = id;
		this.name = name;
		this.price = price;
		this.inStock = inStock;
		this.category = category;
	}
	

	public Producto(Integer product_id, String name, double price, Integer inStock, String image, Categoria category) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.price = price;
		this.inStock = inStock;
		this.image = image;
		this.category = category;
	}

	public Producto() {
		super();
	}

	@Override
	public String toString() {
		return "Producto [id=" + product_id + ", name=" + name + ", price=" + price + ", inStock=" + inStock + ", category="
				+ category + "]";
	}

	

	

	
	
	

}
