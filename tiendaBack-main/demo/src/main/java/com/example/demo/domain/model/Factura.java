package com.example.demo.domain.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="facturas")
public class Factura {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer invoice_id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date invoiceDate;
	
	@Column(nullable = false)
	private double totalPrice;
	
	@ManyToOne
	@JoinColumn(referencedColumnName ="client_id")
	@JsonIgnoreProperties("invoices")
	private Cliente client;
	
	@ManyToMany
	@JoinTable(name="invoices_products", joinColumns = @JoinColumn(name="invoice_id", referencedColumnName="invoice_id"),
	inverseJoinColumns= @JoinColumn(name="product_id", referencedColumnName="product_id"))
    private List<Producto> products;

	public Factura(Date invoiceDate, double totalPrice, Cliente client, List<Producto> products) {
		super();
		this.invoiceDate = invoiceDate;
		this.totalPrice = totalPrice;
		this.client = client;
		this.products = products;
	}

	public Factura() {
		super();
	}

	public Integer getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(Integer invoice_id) {
		this.invoice_id = invoice_id;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Cliente getClient() {
		return client;
	}

	public void setClient(Cliente client) {
		this.client = client;
	}

	public List<Producto> getProducts() {
		return products;
	}

	public void setProducts(List<Producto> products) {
		this.products = products;
	}

	@Override
	public int hashCode() {
		return Objects.hash(invoice_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Factura other = (Factura) obj;
		return Objects.equals(invoice_id, other.invoice_id);
	}

	@Override
	public String toString() {
		return "Factura [invoice_id=" + invoice_id + ", invoiceDate=" + invoiceDate + ", totalPrice=" + totalPrice
				+ ", client=" + client + ", products=" + products + "]";
	}
	
	
	
	

	
	
}