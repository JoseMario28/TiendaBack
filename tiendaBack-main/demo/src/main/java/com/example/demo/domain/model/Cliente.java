package com.example.demo.domain.model;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer client_id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String surname;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String country;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateOfBirth;
	
	@OneToMany(mappedBy="client", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("client")
	private List<Factura> invoices;
	
	/*public void addInvoice(Factura invoice) 
	{
		if (null == invoice) 
		{
			invoices = new List<Factura>();
		}        
		invoices.add(invoice);
		invoice.setClient(this);    
	}*/

	public Cliente(String name, String surname, String email, String country, Date dateOfBirth,
			List<Factura> invoices) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.country = country;
		this.dateOfBirth = dateOfBirth;
		this.invoices = invoices;
	}


	
	public Cliente() {
		super();
	}


	public Integer getClient_id() {
		return client_id;
	}

	public void setClient_id(Integer client_id) {
		this.client_id = client_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<Factura> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Factura> invoices) {
		this.invoices = invoices;
	}



	@Override
	public String toString() {
		return "Cliente [client_id=" + client_id + ", name=" + name + ", surname=" + surname + ", email=" + email
				+ ", country=" + country + ", dateOfBirth=" + dateOfBirth + ", invoices=" + invoices + "]";
	}


	
	
}

	
	