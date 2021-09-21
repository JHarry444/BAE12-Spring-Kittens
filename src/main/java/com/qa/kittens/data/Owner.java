package com.qa.kittens.data;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String contactNumber;

	private String address;

	@OneToMany(mappedBy = "owner") // sets the FK
	private List<Kitten> kittens;

	public Owner(Long id, String name, String contactNumber, String address) {
		super();
		this.id = id;
		this.name = name;
		this.contactNumber = contactNumber;
		this.address = address;
	}

	public Owner() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Kitten> getKittens() {
		return kittens;
	}

	public void setKittens(List<Kitten> kittens) {
		this.kittens = kittens;
	}

}
