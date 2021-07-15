package com.qa.kittens.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
// tells Spring that this class represents a table in the db
public class Kitten {

	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
	private int id;

	@Column(name = "fullName", unique = true)
	private String name;
	private String breed;

	private int age;
	private int cuteness;

	public Kitten(String name, String breed, int age, int cuteness) {
		super();
		this.name = name;
		this.breed = breed;
		this.age = age;
		this.cuteness = cuteness;
	}

	public Kitten() {
		// REQUIRED
	}

	// REQUIRED
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getCuteness() {
		return cuteness;
	}

	public void setCuteness(int cuteness) {
		this.cuteness = cuteness;
	}

	@Override
	public String toString() {
		return "Kitten [name=" + name + ", breed=" + breed + ", age=" + age + ", cuteness=" + cuteness + "]";
	}

}
